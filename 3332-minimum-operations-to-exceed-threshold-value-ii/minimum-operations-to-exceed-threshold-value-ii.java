class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]<k){
                pq.offer((long)nums[i]);
            }
        }
        int count=0;
        while(!pq.isEmpty()){
            if(pq.size()>1){
                long a=pq.poll();
                long b=pq.poll();
                long c=a*(long)2+b;
                System.out.println(c);
                if(c<k){
                    pq.offer(c);
                }
                count++;
            }
            else{
                count++;
                pq.poll();
            }
        }
        return count;
    }
}