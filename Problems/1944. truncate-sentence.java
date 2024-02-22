// https://leetcode.com/problems/truncate-sentence

// class Solution {
//     public String truncateSentence(String s, int k) {
//         String[] arr =  s.split(" ");
        
//         StringBuilder sb = new StringBuilder();
        
//         for(int i=0; i<k; i++){
//             sb.append(arr[i]);
//             sb.append(" ");
//         }
        
//         return sb.toString().trim();
//     }
// }

class Solution 
{
    public String truncateSentence(String s, int k) 
    {
        int c=0,i;
        for(i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(ch==' ')
                c++;
            if(c==k)
                break;
        }
        return s.substring(0,i);
    }
}