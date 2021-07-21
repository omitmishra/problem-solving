class Solution {
  public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int ProfitOne = 0;
        for(int p : prices) {
            buyOne = Math.min(buyOne, p);
            ProfitOne = Math.max(ProfitOne, p - buyOne);
        }
        return ProfitOne;
    }
}