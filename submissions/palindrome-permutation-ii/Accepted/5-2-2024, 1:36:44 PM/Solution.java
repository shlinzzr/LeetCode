// https://leetcode.com/problems/palindrome-permutation-ii

class Solution {

    Character singleChar = null;
    public List<String> generatePalindromes(String s) {

        int len = s.length();
        List<String> res= new ArrayList<>();
        int[] arr = new int[26];

        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        boolean single = false;
        for(int i=0; i<26;i++){
            if(arr[i]%2==1){
                if(single) return res;
                single = true;
                singleChar = (char)(i+'a');
            }
        }

        helper(arr, new StringBuilder(), res, s.length());

        return res;
    }

    private void helper(int[] arr, StringBuilder sb, List<String> res, int len){

        if(sb.length()*2==len){
            res.add(sb.toString()+sb.reverse().toString());
            sb.reverse();
            return;
        }else if(sb.length()*2 + 1 ==len){
            res.add(sb.toString()+singleChar + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for(int i=0; i<26; i++){

            if(arr[i]<2) continue;
            arr[i]-=2;
            sb.append((char)(i+'a'));
            helper(arr, sb, res, len);
            sb.deleteCharAt(sb.length()-1);
            arr[i]+=2;
        }



    }
}