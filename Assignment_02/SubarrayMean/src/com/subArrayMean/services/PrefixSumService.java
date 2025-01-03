package com.subArrayMean.services;

public class PrefixSumService {
    private long[] prefixSumArray;

    public PrefixSumService() {
    	
    }
    public PrefixSumService(long[] array) {
        this.prefixSumArray = new long[array.length + 1];
        calculatePrefixSum(array);
    }

    private void calculatePrefixSum(long[] array) {
        prefixSumArray[0] = 0;
        for (int i = 1; i <= array.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + array[i - 1];
        }
    }

    public long getPrefixSum(int left, int right) {
        return prefixSumArray[right] - prefixSumArray[left-1];
    }
}
