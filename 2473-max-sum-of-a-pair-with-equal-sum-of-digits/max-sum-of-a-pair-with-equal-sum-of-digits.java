class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int nsum;
        int ans = -1;
        for(int i : nums){
            nsum = nsum(i);
            if(!map.containsKey(nsum)){
                map.put(nsum, i);
            }else{
                ans = Math.max(ans, map.get(nsum) + i );
                map.put(nsum, Math.max(map.get(nsum), i));
            }
        }
        return ans;
    }
    public int nsum(int n){
        int sum =0;
        while(n != 0){
        sum += n % 10;
        n = n / 10; 
        }
        return sum;
    }
}