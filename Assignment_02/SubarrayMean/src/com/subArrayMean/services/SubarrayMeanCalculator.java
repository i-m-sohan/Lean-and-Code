package com.subArrayMean.services;

public class SubarrayMeanCalculator {
	private PrefixSumService prefixSumService;
	public SubarrayMeanCalculator() {
		prefixSumService = new PrefixSumService();
	}
	
	public SubarrayMeanCalculator(PrefixSumService prefixSumService) {
		this.prefixSumService = prefixSumService;
	}
	
	public Long evaluateSubarrayMean(int leftIndex, int rightIndex) {
		return (prefixSumService.getPrefixSum(leftIndex, rightIndex))/(rightIndex-leftIndex+1);
	}
}
