class Solution {
    public static boolean canPartition(int[] nums) {
        int n=nums.length,totalsum=0;
        for(int num:nums){
            totalsum+=num;
        }
        if(totalsum%2!=0){
            return false;
        }
        int target = totalsum / 2;
        int[][] dp=new int[n+1][target+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return subsetsum(nums,target,n,dp);
    }
    public static boolean subsetsum(int[] arr,int sum,int n,int[][] dp){
        if(sum==0){
            return true;
        }
        if(n==0){
            return false;
        }
        if(dp[n][sum] != -1){
            return dp[n][sum]==1;
        }
        boolean pair=false;
        if(arr[n-1]<=sum){
            pair=subsetsum(arr,sum-arr[n-1],n-1,dp);
        }
        boolean notpair=subsetsum(arr,sum,n-1,dp);
        dp[n][sum] = (notpair || pair) ? 1 : 0;
        return dp[n][sum]==1;
    }
}