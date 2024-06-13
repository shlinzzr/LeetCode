// https://leetcode.com/problems/unique-email-addresses

class Solution {
    
    int[] parent;
    
    
    public int numUniqueEmails(String[] emails) {
        int len = emails.length;
        parent = new int[len];
        for(int i=0; i<len; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<len; i++){
            for(int j= i+1; j<len; j++){
                
                String sa = emails[i];
                String sb = emails[j];
                
                if(isEqual(sa, sb)){
                    union(i, j);
                }
            }            
        }
        
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(parent[i]==i)
                cnt++;
        }
        
        return cnt;
        
        
    }
    
    private boolean isEqual(String sa, String sb){
        
        String lna = sa.split("@")[0];
        String dna = sa.split("@")[1];
        
        String lnb = sb.split("@")[0];
        String dnb = sb.split("@")[1];
        
        if(!dna.equals(dnb)) return false;
        
        lna = lna.replaceAll("\\.", "");
        lnb = lnb.replaceAll("\\.", "");
        
        if(lna.contains("+"))
            lna = lna.substring(0, lna.indexOf("+"));
        if(lnb.contains("+"))
            lnb = lnb.substring(0, lnb.indexOf("+"));
        
        return lna.equals(lnb) && dna.equals(dnb);
        
        
        
        
    }
    
    private void union(int a, int b){
        
        a = find(a);
        b = find(b);
        
        if(a==b) return ;
        
        parent[b]=parent[a];
    }
    
    
    private int find(int i){
        if(parent[i]!=i){
            parent[i] =  find(parent[i]);
        }
        
        return parent[i];
    }
}