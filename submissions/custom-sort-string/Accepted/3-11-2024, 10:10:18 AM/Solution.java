// https://leetcode.com/problems/custom-sort-string

class Solution {
    public String customSortString(String order, String s) {

        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++){

            char ch = order.charAt(i);

            for(int j=0; j<arr[ch-'a']; j++){
                sb.append(ch);
            }
            arr[ch-'a']=0;
        }

        for(int i=0; i<26; i++){
            if(arr[i]!=0){
                for(int j=0; j<arr[i]; j++){
                    sb.append( (char)('a'+i));
                }
            }
        }

        return sb.toString();

    }
}