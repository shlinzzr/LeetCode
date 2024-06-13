// https://leetcode.com/problems/text-justification

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> rets = new ArrayList<>();
        
        int len = words.length;
        
        int idx = 0;
        
        for (int i=0; i<words.length; i++)
        {
            int j = i, count = 0;
            while (j<words.length && count <= maxWidth)
            {
                if (count==0)
                    count += words[j].length();
                else
                    count += 1 + words[j].length();
                j++;
            }
            j--;// recover j 
            if (count > maxWidth)// recover count
            {
                count -= 1 + words[j].length();
                j--;
            }
            
            
            
            if (j==words.length-1) // the last line
            {
                String temp="";
                for (int k=i; k<=j; k++)
                    temp += words[k]+" ";
                
                // temp.pop_back();
                temp = temp.substring(0, temp.length()-1);
                temp += addspace(maxWidth - temp.length());
                
                rets.add(temp);
            }                
            else
            {
                rets.add(printline(words, i, j, maxWidth));
            }
                
            i = j;                        
        }
        return rets;
    }
    
    private String printline(String[] words, int a, int b, int maxWidth)
    {
        if (a==b)
        {
            return words[a] + addspace(maxWidth-words[a].length());
        }
        
        int total = 0;
        for (int i=a; i<=b; i++) total += words[i].length();
        int space = (maxWidth - total)/Math.max(1, b-a);
        int extra = maxWidth - total - space * (b-a);
        
        String ret="";
        for (int i=a; i<a+extra; i++)    
            ret += words[i] + addspace(space+1);        
        for (int i=a+extra; i<b; i++)        
            ret += words[i] + addspace(space);
        
        ret+=words[b];              
        return ret;        
    }
    
    private String addspace(int k)
    {
        String ret="";
        for (int i=0; i<k; i++)
            ret+=" ";
        return ret;
    }
        
        
        
}