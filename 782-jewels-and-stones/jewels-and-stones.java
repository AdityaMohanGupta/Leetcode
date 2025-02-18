class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> st=new HashSet<>();
        for(char h:jewels.toCharArray()){
            st.add(h);
        }
        int count=0;
        for(char h:stones.toCharArray()){
            if(st.contains(h)){
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }
}