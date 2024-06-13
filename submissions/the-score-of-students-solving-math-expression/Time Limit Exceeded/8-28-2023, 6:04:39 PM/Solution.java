// https://leetcode.com/problems/the-score-of-students-solving-math-expression

class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int len = s.length();
        
        // prepare input
        List<String> input = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                sum=sum*10 + (ch-'0');
            }else{
                input.add(""+sum);
                sum=0;
                input.add(ch+"");
            }
        }
        input.add(""+sum);
        
        
        int correct=0;
        
        List<String> vals = new ArrayList<>(input);
        for(int i=0; i<vals.size(); i+=2){
            
            int cur = Integer.valueOf(vals.get(i));
            
            while(i+1<vals.size() && "*".equals(vals.get(i+1))){
                cur = cur* Integer.valueOf(vals.get(i+2));
                i+=2;
            }
            
            correct+=cur;
        }
        
        
        
        
        
        List<Integer> list = new ArrayList<>();
        
        dfs(input, list);
        
        HashSet<Integer> set = new HashSet<>(list);
        set.remove(correct);
        
        
        
        int res = 0;
        
        for(int a: answers){
            if(a==correct)
                res+=5;
                
            else if(set.contains(a))
                res+=2;
        }
        
        return res;
        
        
        
    }
    
    
    private void dfs(List<String> input, List<Integer> res){
        
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