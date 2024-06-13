// https://leetcode.com/problems/push-dominoes

class Solution {

    //https://leetcode.com/problems/push-dominoes/solutions/2628946/java-easy-solution-with-comments-89-faster-code-stringbuilder/

    public String pushDominoes(String D) {
        int len = D.length();
        boolean[] forward = new boolean[len];


        char prev= '.';
        for(int i=0; i<len; i++){
            char ch = D.charAt(i);
            if(ch=='R' || (prev=='R' && ch=='.')){
                forward[i]=true;
            }
            if(ch!='.')
                prev=ch;
        }


        boolean[] backward = new boolean[len];
        prev = '.';
        for(int i=len-1; i>=0; i--){
            char ch = D.charAt(i);
            if(ch=='L' || (prev=='L' && ch=='.')){
                backward[i]=true;
            }
            if(ch!='.')
                prev=ch;
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<len; i++){
            char ch = D.charAt(i);

            if(forward[i] && !backward[i]){
                sb.append('R');
            }else if(!forward[i] && backward[i]){
                sb.append('L');
            }else if(forward[i] && backward[i]){

                int j = i+1;
                while(j<len && forward[j] && backward[j]){
                    j++;
                }

                helper(sb, i, j-1);
                i=j;
            }else{
                sb.append('.');
            }

        }

        return sb.toString();
    }

    private void helper(StringBuilder sb, int i, int j){

        int t = j;
        while(i<t){
            sb.append('R');
            i++;
            t--;
        }

        if(i==t){
            sb.append('.');
        }

        while(t<=j){
            sb.append('L');
            t++;
        }

    }
}