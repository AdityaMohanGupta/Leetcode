class Solution {
    public int helper (int nums[], int k){
        int left=0,right=0,cnt=0;
        Map<Integer,Integer> map = new HashMap<>();
        while(right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0) map.remove(nums[left]);
                    left++;
                
            }
            cnt =cnt+(right-left+1);
            right++;

        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }
}