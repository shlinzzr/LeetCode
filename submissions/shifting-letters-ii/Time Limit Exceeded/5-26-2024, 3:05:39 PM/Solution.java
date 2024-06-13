// https://leetcode.com/problems/shifting-letters-ii

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] arr = s.toCharArray();
        for(int[] act : shifts){
            helper(arr, act);
        }

        return new String(arr);
    }


    private void helper(char[] arr, int[] shift){
        int start = shift[0];
        int end = shift[1];
        int dir = shift[2]==0 ? -1 : 1;

        for(int i=start; i<=end; i++){
            int idx = arr[i]-'a';
            idx = (idx+26+dir)%26;
            arr[i] = (char) ('a'+idx);
        }
    }
}