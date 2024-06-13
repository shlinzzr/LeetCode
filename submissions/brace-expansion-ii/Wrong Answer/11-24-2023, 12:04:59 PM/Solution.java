// https://leetcode.com/problems/brace-expansion-ii

class Solution {
    public List<String> braceExpansionII(String ex) {
        System.out.println("ex="+ex);
        List<List<Character>> dict = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        
        int len = ex.length();
        for(int i=0; i<len ; i++){
            char ch = ex.charAt(i);
            System.out.println("ch="+ch + " curr="+ curr);
            if(ch==','){
                
                if(ex.charAt(i+1)=='{'){
                    i++;
                    int j=i+1;
                    for(int cnt=0; i<len; i++){
                        if(ex.charAt(i)=='{') cnt++;
                        if(ex.charAt(i)=='}') cnt--;
                        if(cnt==0) break;
                    }

                    List<String> rt = braceExpansionII(ex.substring(j,i));
                    for(String r : rt){
                        curr.add(r);
                    }
                }

            }else if(ch=='{'){
                int j=i+1;
                for(int cnt=0; i<len; i++){
                    if(ex.charAt(i)=='{') cnt++;
                    if(ex.charAt(i)=='}') cnt--;
                    if(cnt==0) break;
                }
                
                List<String> rt = braceExpansionII(ex.substring(j,i));
                List<String> tmp = new ArrayList<>();
                if(curr.isEmpty()) curr.add("");
                for(String c: curr){
                    for(String r : rt){
                        tmp.add(c+r);
                    }
                }

                curr= new ArrayList<>(tmp);
            
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                while(i+1<len && ex.charAt(i+1)>='a' && ex.charAt(i+1)<='z')
                    sb.append(ex.charAt(++i));

                curr.add(sb.toString());
            }
        }

            System.out.println("return curr="+curr);
        return curr;


        
    }
}