import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//Too short timeouts might lead to false positives (connection/read failures), while
//too long timeouts might make the application unresponsive in case of actual issues.
public class ImageFetcher {

    private final int CONNECT_TIMEOUT = 5000;
    private final int READ_TIMEOUT = 5000;
    private final String URL_TEMPLATE = "https://%s.tumblr.com/api/read/json?type=photo&num=%d&start=%d";
    public BlogData fetchBlogData(String blogName,int startPost,int endPost) throws IOException {
        String apiUrl = prepareApiUrl(blogName,startPost,endPost);
        String jsonResponse = ApiUtils.fetchApiResponse(apiUrl, CONNECT_TIMEOUT, READ_TIMEOUT);
        return parseBlogData(jsonResponse);
    }
    	
    private String prepareApiUrl(String blogName,int startPost,int endPost) {
        String finalUrl = String.format(URL_TEMPLATE, blogName, endPost-startPost+1, startPost);
        return finalUrl;
    }

    private BlogData parseBlogData(String jsonResponse) throws IOException {
        try {
            if (jsonResponse.startsWith("var tumblr_api_read = ")) { 
                jsonResponse = jsonResponse.substring("var tumblr_api_read = ".length()); // Remove extra JavaScript code to parse JSON
            } else {
                throw new IOException("Unexpected response format from Tumblr API.");
            }
            JSONObject jsonObject = new JSONObject(jsonResponse);
            return createBlogData(jsonObject);

        } catch (org.json.JSONException e) {
            throw new IOException("Invalid JSON response: " + e.getMessage());
        }
    }

    private BlogData createBlogData(JSONObject jsonObject) {
        JSONObject tumblelog = jsonObject.getJSONObject("tumblelog");
        String title = tumblelog.optString("title", "N/A");
        String name = tumblelog.optString("name", "N/A");
        String description = tumblelog.optString("description", "N/A");
        int totalPosts = jsonObject.optInt("posts-total", 0);

        BlogData blogData = new BlogData(title, name, description, totalPosts);
        JSONArray posts = jsonObject.getJSONArray("posts");

        for (int i = 1; i <= posts.length(); i++) {
            JSONObject post = posts.getJSONObject(i-1);
            Set<String> imageUrls = extractImageUrls(post);
            blogData.addImageUrls(i,imageUrls); 
        }
        return blogData;
    }


    private Set<String> extractImageUrls(JSONObject post) {
    	Set<String> imageUrls = new HashSet<>();

        String highestQualityTopLevelUrl = null;
        int maxResolutionTopLevel = 0;
        for (String key : post.keySet()) {
            if (key.startsWith("photo-url-")) {
                String url = post.getString(key);
                int resolution = Integer.parseInt(key.replace("photo-url-", ""));
                if (resolution > maxResolutionTopLevel) {
                    maxResolutionTopLevel = resolution;
                    highestQualityTopLevelUrl = url;
                }
            }
        }
        if (highestQualityTopLevelUrl != null) {
            imageUrls.add(highestQualityTopLevelUrl);
        }
        
        if (post.has("photos")) {
            JSONArray photosArray = post.getJSONArray("photos");
            for (int j = 0; j < photosArray.length(); j++) {
                JSONObject photo = photosArray.getJSONObject(j);

                String highestQualityUrl = null;
                int maxResolution = 0;

                for (String key : photo.keySet()) {
                    if (key.startsWith("photo-url-")) {
                        String url = photo.getString(key);
                        int resolution = Integer.parseInt(key.replace("photo-url-", ""));
                        if (resolution > maxResolution) {
                            maxResolution = resolution;
                            highestQualityUrl = url;
                        }
                    }
                }

                if (highestQualityUrl != null) {
                    imageUrls.add(highestQualityUrl);
                }
            }
        }
        return imageUrls;
    }
}