// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int len = deck.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int d: deck){
            map.put(d, map.getOrDefault(d,0)+1);
        }
        

        // 找到所有數字出現次數的最大公因數
        int gcd = 0;
        for (int count : map.values()) {
            gcd = gcd(gcd, count);
        }

        // 如果最大公因數大於1，則返回true；否則返回false
        return gcd > 1;
    }

    // 找到兩個數字的最大公因數
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}