class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int a=0;
        int b=0;
        for(int g:arr1){
            a^=g;
        }
        for(int g:arr2){
            b^=g;
        }
        return a&b;
    }
}