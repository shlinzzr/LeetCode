// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop

class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len+1);

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<len; i++){
            
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        int [] res= new int[len];
        for(int i=0; i<len ;i++){
            int p = prices[i];
            int discount = nextSmaller[i];
            if(discount==len+1){
                discount = 0;
            }else{
                discount = prices[nextSmaller[i]];
            }
            res[i] = p-discount;


        }

        return res;

        
    }
}