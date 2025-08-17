class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st=new ArrayDeque<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peekLast()<nums2[i]){
                st.pollLast();
            }
            if(st.isEmpty()){
                map.put(nums2[i],-1);
            }
            else{
                map.put(nums2[i],st.peekLast());
            }
            st.offerLast(nums2[i]);
        }
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        //     System.out.println(entry.getKey()+" ->"+entry.getValue());
        // }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        } 
        return nums1; 
    }
}