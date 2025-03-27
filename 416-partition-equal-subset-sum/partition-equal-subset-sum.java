    //    NORMAL DP
// class Solution {
//     public static boolean canPartition(int[] nums) {
//         int n=nums.length,totalsum=0;
//         for(int num:nums){
//             totalsum+=num;
//         }
//         if(totalsum%2!=0){
//             return false;
//         }
//         int target = totalsum / 2;
//         int[][] dp=new int[n+1][target+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return subsetsum(nums,target,n,dp);
//     }
//     public static boolean subsetsum(int[] arr,int sum,int n,int[][] dp){
//         if(sum==0){
//             return true;
//         }
//         if(n==0){
//             return false;
//         }
//         if(dp[n][sum] != -1){
//             return dp[n][sum]==1;
//         }
//         boolean pair=false;
//         if(arr[n-1]<=sum){
//             pair=subsetsum(arr,sum-arr[n-1],n-1,dp);
//         }
//         boolean notpair=subsetsum(arr,sum,n-1,dp);
//         dp[n][sum] = (notpair || pair) ? 1 : 0;
//         return dp[n][sum]==1;
//     }
// }

  //  TABULAR FORM
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
        boolean[][] dp=new boolean[n+1][target+1];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
                boolean pair=false;
                if(nums[i-1]<=j){
                    pair=dp[i-1][j-nums[i-1]];
                }
                boolean notpair=dp[i-1][j];
                dp[i][j]= pair|| notpair;
            }
        }
        return dp[n][target];
    }
}






