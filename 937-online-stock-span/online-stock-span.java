class StockSpanner {
    Stack<Integer> prices=new Stack<>();
    Stack<Integer> days=new Stack<>();; 
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int count=1;
        while(!prices.isEmpty() && prices.peek()<=price){
            prices.pop();
            count+=days.pop();
        }
        prices.push(price);
        days.push(count);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */