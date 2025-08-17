class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr=new int[nums.length];
        Deque<Integer> st=new ArrayDeque<>();
        // Map<Integer,Integer> map=new HashMap<>();
        for(int i=2*nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peekLast()]<=nums[i%nums.length]){
                st.pollLast();
            }
            arr[i%nums.length]=st.isEmpty()?-1:nums[st.peekLast()];
            st.offerLast(i % nums.length);
        }
        return arr;
    }
}