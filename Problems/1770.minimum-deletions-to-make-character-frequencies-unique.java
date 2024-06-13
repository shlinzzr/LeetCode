// https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique

class Solution {
    public int minDeletions(String s) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        int cnt= 0;
        HashSet<Integer> set = new HashSet<>();
        for(int a: arr){

            while(set.contains(a) && a!=0){
                a--;
                cnt++;
            }
            set.add(a);

        }

        return cnt;
    }
}