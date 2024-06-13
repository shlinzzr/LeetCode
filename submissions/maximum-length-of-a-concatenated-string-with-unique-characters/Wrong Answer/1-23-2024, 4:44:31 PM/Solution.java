// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    public int maxLength(List<String> arr) {
        List<String> res = new ArrayList<>();

        helper(arr, 0, "", res);
        int max =0;
        for(String r : res){
            max = Math.max(max, r.length());
        }
        return max;
    }

    private void helper(List<String> arr, int idx, String curr, List<String> res){
        if(idx==arr.size()){
            res.add(curr);
            return;
        }

        for(int i=idx; i<arr.size(); i++){

            boolean dul= false;
            int[] t = new int[26];
            for(char ch : curr.toCharArray()){
                t[ch-'a']++;
            }
            for(char ch : arr.get(i).toCharArray()){
                t[ch-'a']++;
            }

            for(int a : t){
                if(a>1) dul=true;
            }

            if(dul) continue;
            helper(arr, i+1, curr+arr.get(i), res);
        }
    }
}