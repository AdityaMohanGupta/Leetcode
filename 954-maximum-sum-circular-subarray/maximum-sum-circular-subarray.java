class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int omax=Integer.MIN_VALUE;
        int omin=Integer.MAX_VALUE;
        int csum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        for(int i=0;i<nums.length;i++){
            if(csum<0){
                csum=nums[i];
            }
            else{
                csum+=nums[i];
            }
            omax=Math.max(csum,omax);
        }

        csum=0;
        for(int i=0;i<nums.length;i++){
            if(csum>0){
                csum=nums[i];
            }
            else{
                csum+=nums[i];
            }
            omin=Math.min(csum,omin);
        }
        int cirsum=sum-omin;
        return omax>0?Math.max(omax,cirsum):omax;
    
    }
}