class Solution {
    public int maxDifference(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int a1=0;
        int a2=100;
        for(int g:map.values()){
            if(g%2==0){
                a2=Math.min(a2,g);
            }
            else{
                a1=Math.max(a1,g);
            }
        }
        return a1-a2;
    }
}