class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0){
            return new int[0];
        }
        int n =nums.length;
        int[] arr=new int[n-k+1];
        int idx=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            // 1. Remove indices out of window
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            // 2. Remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            // 3. Add current index
            dq.offerLast(i);
            // 4. The maximum is at the front
            if(i>=k-1){
                arr[idx]=nums[dq.peekFirst()];
                idx++;
            }
        }
        return arr;
    }
}