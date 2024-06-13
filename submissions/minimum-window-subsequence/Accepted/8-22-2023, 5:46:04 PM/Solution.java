// https://leetcode.com/problems/minimum-window-subsequence

class Solution {
    public String minWindow(String s1, String s2) {
        
        //huifeng 狀態機。https://www.bilibili.com/video/BV18w411o7NA/?spm_id_from=333.337.search-card.all.click
        
        
        
        int m = s1.length();
        s1 = "#"+s1;
        
        int[][] next = new int[m+1][26]; //站在第m位往後看找ch的的idx;
        
        for(int ch=0; ch<26 ; ch++) {//初始化所有最後看到的下一個char 都是空的
            next[m][ch] = -1;
        }
        
        for(int i=m-1; i>=0; i--){ // 由後往前
            for(int ch=0; ch<26; ch++)
                next[i][ch] = next[i+1][ch]; //一般狀況 我看的跟之前看的都一樣
            next[i][s1.charAt(i+1)-'a']=i+1; // 唯一要更新的就是i+1這位的char最近的位置是i+1
        }
        
        //找所有起點
        List<Integer> start = new ArrayList<>();
        for(int i=1; i<=m; i++){
            if(s1.charAt(i)==s2.charAt(0))
                start.add(i);
        }
        
        String ret="";
        
        for(int i : start){
            int j=i-1; // i-1位向右看
            boolean flag=true;
            
            for(char ch : s2.toCharArray()){ //遍歷s2
                j = next[j][ch-'a'];
                if(j==-1){ //如果找不到
                    flag=false;
                    break;
                }
            }
            if(flag){ //找到了
                int wLen = j-i+1;
                if(ret.isEmpty() || wLen<ret.length())
                    ret = s1.substring(i, i+wLen);
            }
        }
        
        return ret;
            
            
            
        
        
        
        
        /*
        
        // sliding window O(S*(m+n))  2775ms,  5.94% 
        
        int len = s1.length();
        String[] dp = new String[len+1]; // 執行到第i個字符的 min subseq?
        
        if(s1.equals(s2))
            return s1;
        
        String res = s1+"#";
        
        
        for(int i1=0; i1<s1.length(); i1++){
        
            int i2 = 0;
            
            if(s1.charAt(i1)!=s2.charAt(i2)){
                continue;
            }
            
            int st=i1, ed=i1;
            while(ed<s1.length() && i2<s2.length()){
                
                if(s1.charAt(ed)==s2.charAt(i2)){
                    i2++;
                    ed++;
                }else{
                    ed++;
                }
            }
            
            String sub = s1.substring(st, ed);
            
            if(i2==s2.length() && sub.length()<res.length()){
                res = sub;
            }
            
        }
        
        return res.length()==len+1 ? "" : res;
        */
        
    }
}