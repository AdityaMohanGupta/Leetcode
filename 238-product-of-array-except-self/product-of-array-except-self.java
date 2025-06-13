class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=nums[0];
        for(int i=1;i<n;i++){
            left[i]=left[i-1]*nums[i];
        }
        right[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i];
        }
        nums[0]=right[1];
        nums[n-1]=left[n-2];
        for(int i=1;i<n-1;i++){
            nums[i]=left[i-1]*right[i+1];
        }
        return nums;
    }
}

// without extra space
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] result = new int[nums.length];
//         Arrays.fill(result, 1);
//         for(int i = nums.length - 2; i >= 0; i--){
//             result[i] = result[i + 1] * nums[i + 1];
//         }
//         int tmp = nums[0];
//         for(int j = 1; j < nums.length; j++){
//             result[j] = result[j] * tmp;
//             tmp = tmp * nums[j];
//         }
//         return result;
        
//     }
// }