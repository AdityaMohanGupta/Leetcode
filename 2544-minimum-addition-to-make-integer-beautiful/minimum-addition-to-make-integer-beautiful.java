class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long n0=n,base=1;
        while(add(n)>target){
            n=n/10+1;
            base*=10;
        }
        return n*base-n0;
    }
    public static long add(long num){
        long add=0;
        while(num>0){
            long n=num%10;
            num/=10;
            add+=n;
        }
        return add;
    }
}