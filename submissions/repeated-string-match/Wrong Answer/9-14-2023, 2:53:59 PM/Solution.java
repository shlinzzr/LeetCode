// https://leetcode.com/problems/repeated-string-match

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int res = 0;

        if((b+b).indexOf(a)==-1)
            return -1;

        int i=0;
        int j=(b+b).indexOf(a);
        int cnt= 0 ;


        if(j!=0)
            cnt++;
        
        while(j<b.length()){

            char cha = a.charAt(i%a.length());
            char chb = b.charAt(j);

            if(cha!=chb)
                return -1;
            
            if(i%a.length()==a.length()-1)
                cnt++;

            j++;
            i++;
        }

        return (i%a.length()==a.length()-1) ? cnt : cnt+1;




    }
}