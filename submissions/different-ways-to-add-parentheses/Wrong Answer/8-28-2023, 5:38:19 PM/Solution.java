// https://leetcode.com/problems/different-ways-to-add-parentheses

class Solution {
    
    Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*"));
    
    public List<Integer> diffWaysToCompute(String exp) {
        
        
        int len = exp.length();
        
        // prepare input
        List<String> input = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<len; i++){
            char ch = exp.charAt(i);
            if(Character.isDigit(ch)){
                sum=sum*10 + (ch-'0');
            }else{
                input.add(""+sum);
                sum=0;
                input.add(ch+"");
            }
        }
        input.add(""+sum);
        // System.out.println(input);
        
        Set<Integer> res = new HashSet<>();
        
        dfs(input, res);
        
        return new ArrayList<>(res);
    }
    
    private void dfs(List<String> input, Set<Integer> res){
        
        if(input.size()==1){
            
            
            res.add(Integer.valueOf(input.get(0)));
            return;
        }
        
        for(int i=0; i<input.size(); i+=2){
            
            for(int j=i+2; j<input.size(); j+=2){
                List<String> tmp = new ArrayList<>();
                boolean done = false;
                
                // System.out.println("i="+i +" j="+j);
                
                for(int k=0; k<input.size(); k++){
                    
                    // System.out.println("k="+k+ " v="+input.get(k) + " tmp="+tmp);
                    
                    if(k>=i && k<=j) {
                        if(done)
                            continue;
                        
                        int val = cal(input, i, j);
                        tmp.add(""+val);
                        done=true;
                        
                    }else
                        tmp.add(input.get(k));
                }
                
                
                dfs(tmp, res);
            }
        }
    }
    
    private int cal(List<String> in, int st, int ed){
        
        int res = Integer.valueOf(in.get(st));
        
        for(int i=st+1; i<ed; i+=2){
            
            String op = in.get(i);
            int val = Integer.valueOf(in.get(i+1));
            
            if("+".equals(op)){
                res += val;
            }else if("-".equals(op)){
                res -= val;
            }else{
                res *=val;
            }
        }
        
           // System.out.println("res="+res);
        return res;
        
        
    }
    
}
