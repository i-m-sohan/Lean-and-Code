package com.subArrayMean;

import java.util.Scanner;

import com.subArrayMean.services.PrefixSumService;
import com.subArrayMean.services.SubarrayMeanCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("No of elements : ");
        int numberOfElements = scanner.nextInt();
        System.out.println("No of Queries : ");
        int noOfQueries = scanner.nextInt();
        
        System.out.println("Give Elements :");
        long[] arr = new long[numberOfElements];
        for (int index = 0; index < numberOfElements; index++) {
            arr[index] = scanner.nextLong();
        }

        PrefixSumService prefixSumService = new PrefixSumService(arr);
        SubarrayMeanCalculator subarrayMeanCalculator = new SubarrayMeanCalculator(prefixSumService);

        for (int queryCount = 1; queryCount <= noOfQueries; queryCount++) {
        	System.out.println("Query "+queryCount);
        	System.out.println("Left position : ");
            int leftIndex = scanner.nextInt();
        	System.out.println("Right position : ");
            int rightIndex = scanner.nextInt();

            long subarrayMean = subarrayMeanCalculator.evaluateSubarrayMean(leftIndex,rightIndex);
            System.out.println("Subarray Mean : "+subarrayMean);
        }
        scanner.close();
    }
}
