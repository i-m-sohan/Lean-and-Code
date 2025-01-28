import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainService {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the blog name: ");
        String blogName = scanner.nextLine();
        
        System.out.print("Enter the range : ");
        String range = scanner.nextLine();

        String[] parts = range.split("-");
        int startPost = Integer.parseInt(parts[0].trim());
        int endPost = Integer.parseInt(parts[1].trim());
        
		try {
			ImageFetcher imageFetcher = new ImageFetcher();
			BlogData blogData = imageFetcher.fetchBlogData(blogName,startPost,endPost);
			Map<Integer,Set<String>> postNoWithImageUrls = blogData.getPostNoWithImageUrls();
			System.out.println("Blog Information:");
            System.out.println("Title: " + blogData.getTitle());
            System.out.println("Name: " + blogData.getName());
            System.out.println("Description: "+ blogData.getDescription());
            System.out.println("No of Posts: "+ blogData.getTotalPosts());
			for(Integer postNo : postNoWithImageUrls.keySet()) {
				System.out.print(postNo + ". ");
				for(String imageUrl : postNoWithImageUrls.get(postNo)) {
					System.out.println(imageUrl);
				}
			}
		}
		catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
		scanner.close();
	}
}

