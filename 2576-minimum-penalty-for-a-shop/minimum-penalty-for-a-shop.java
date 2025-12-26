class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] front=new int[n+1];
        int[] back=new int[n+1];
        front[0]=0;
        back[n]=0;
        for(int i=0;i<n;i++){
            int count=0;
            char c=customers.charAt(i);
            if(c=='N'){
                count++;
            }
            front[i+1]=front[i]+count;
        }
        for(int i=n-1;i>=0;i--){
            int count=0;
            char c=customers.charAt(i);
            if(c=='Y'){
                count++;
            }
            back[i]=back[i+1]+count;
        }
        int min=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<n+1;i++){
            if((front[i]+back[i])<min){
                min=front[i]+back[i];
                result=i;
            }
        }
        return result;
    }
}