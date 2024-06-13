// https://leetcode.com/problems/zuma-game

class Solution {
    public int findMinStep(String board, String hand) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        for(int i=0; i<hand.length(); i++){
            char c = hand.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) +1);
        }
        return dfs(board, freq, new HashMap<>());
    }
    
    public int dfs(String board, HashMap<Character, Integer> freq, Map<String, Integer> memo) {
        if (memo.containsKey(board)) {
            return memo.get(board);
        }
        
        int res = Integer.MAX_VALUE;
        if (board.length() == 0) {
            res = 0;
        } else {
            StringBuilder sb = new StringBuilder(board);
            for (int i = 0; i<sb.length(); i++) {
                for (char c: freq.keySet()) {
                    if (freq.get(c) > 0) {
                        sb.insert(i, c);
                        freq.put(c, freq.get(c) - 1);
                        
                        String newBoard = squeezeString(sb.toString());
                        
                        int temp = dfs(newBoard, freq, memo);
                        if (temp != -1) {
                            res = Math.min(res, temp + 1);
                        }
                        //backtracking
                        sb.deleteCharAt(i);
                        freq.put(c, freq.get(c) + 1);
                    }
                }
            }   
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(board, res);
        return res;
    }
    
    public String squeezeString(String board){
        int i = 0;
        int j = 0;
        while (i<board.length()) {
            while (j<board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            if (j-i>=3) {
                return squeezeString(board.substring(0, i) + board.substring(j));
            } else {
                i++;
            }
        }
        return board;
    }
}