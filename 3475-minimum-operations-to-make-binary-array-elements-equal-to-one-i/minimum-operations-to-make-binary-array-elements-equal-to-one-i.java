class Solution {
    public int minOperations(int[] nums) {
        if(nums.length < 3){ 
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    return -1;
                }
            }
            return 0;
        }
        int ans = 0;
        for(int i = 0; i <= nums.length -3; i++){ 
            if(nums[i] == 0){   
                nums[i] = 1 - nums[i];
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                ans++;
            }
        }
        for (int i = nums.length - 2; i < nums.length; i++) {  
            if (nums[i] == 0) {
                return -1;
            }
        } 
        return ans;
    }
}