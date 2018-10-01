class StockSpanner {
    private List<Integer> prices;
    List<Integer> memo;
    public StockSpanner() {
        prices = new ArrayList<Integer>();
        memo = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        prices.add(price);
        if(prices.size() == 1) {
            memo.add(1);
            return 1;
        }
        if(prices.get(prices.size() - 2) <= price) {
            int num = 1 + memo.get(memo.size() - 1);
            while(num <= prices.size() && prices.get(prices.size() - num) <= price) {
                int temp = num + memo.get(memo.size() - num + 1);
                if(temp <= prices.size() && prices.get(prices.size() - temp) <= price) {
                    num = temp;   
                } else {
                    num = temp - 1;
                    break;
                }
            }
            memo.add(num);
            return memo.get(memo.size() - 1);
        }
        memo.add(1);
        return 1;
    }
}
