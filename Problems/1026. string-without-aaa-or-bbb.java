// https://leetcode.com/problems/string-without-aaa-or-bbb

class Solution {
    public String strWithout3a3b(int a, int b) {
        
        StringBuilder sb = new StringBuilder();

        while(a>0 && b>0){
            sb.append("ab");
            a--;
            b--;
        }

        System.out.println(sb.toString());

        if(a>0){
            sb.append('a');
            a--;
        }

        if(b>0){
            sb.insert(0, 'b');
            b--;
        }

        for(int i=sb.length(); i>=0 && a>0; i-=2){
            sb.insert(i, 'a');
            a--;
              // System.out.println(sb.toString());
        }

        for(int i=sb.length()-1; i>=0 && b>0; i-=2){
            sb.insert(i, 'b');
            b--;
        }

        return sb.toString();
    }
}