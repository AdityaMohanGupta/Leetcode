class Solution {
    public int addDigits(int num) {
        while(count(num)>1){
            num=add(num);
        }
        return num;
    }
    public static int count(int num){
        int count=0;
        while(num>0){
            num/=10;
            count++;
        }
        return count;
    }
    public static int add(int num){
        int add=0;
        while(num>0){
            int n=num%10;
            num/=10;
            add+=n;
        }
        return add;
    }

}