// https://leetcode.com/problems/longest-subsequence-repeated-k-times

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int N = 26;
        Queue<String> q = new LinkedList<>();
        q.offer("");

        String res = "";
        while(!q.isEmpty()){
            int siz = q.size();

            while(siz-->0){
                String p = q.poll();
                for(char ch='a'; ch<='z'; ch++){
                    if(isSub(s, p+ch, k)){
                        if( (p.length()+1)*k > res.length())
                            res = p+ch;
                        q.offer(p+ch);
                    }
                }

            }
        }

        return res;

    }


    private boolean isSub(String s, String p, int k){

        int j=0;
        for(int i=0; i<s.length(); i++){
            if(p.charAt(j)==s.charAt(i)){
                j++;
                if(j==p.length()){
                    k--;

                    if(k==0) return true;
                    j=0;
                }
            }
        }

        return false;
    }
}