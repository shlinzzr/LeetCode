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
        
        
        // find correct;
        int correct=0;
        List<String> vals = new ArrayList<>(input);
        for(int i=0; i<vals.size(); i+=2){
            
            int cur = Integer.valueOf(vals.get(i));
            
            while(i+1<vals.size() && "*".equals(vals.get(i+1))){
                cur = cur* Integer.valueOf(vals.get(i+2));
                i+=2;
                
                // System.out.println("t="+i);
            }
            
            correct+=cur;
        }
        
        // System.out.println("correct="+correct);
        
        List<Integer> list = leetcode241(s);      
        HashSet<Integer> set = new HashSet<>(list);
        // System.out.println(list);
        
        int res = 0;
        
        for(int a: answers){
            if(a==correct)
                res+=5;
                
            else if(set.contains(a))
                res+=2;
        }
        
        return res;
        
        
        
    }
    
    private List<Integer> leetcode241(String s){
        
        List<Integer> res = new ArrayList<>();
        int len = s.length();
        for(int i=0; i<len; i++){
            
            char ch = s.charAt(i);

            if(ch=='+' || ch=='*'){
                
                List<Integer> lista = leetcode241(s.substring(0, i));
                List<Integer> listb = leetcode241(s.substring(i+1, len));
                
                
                for(int a : lista){
                    for(int b : listb){
                        
                        if(ch=='+' && a+b<=1000){
                            res.add(a+b);
                        }else if(ch=='*' && a*b<=1000){
                            res.add(a*b);
                        }
                    }
                }
            }
        }
        if(res.size()==0){
            res.add(Integer.valueOf(s));
        }
        
        return res;
    }
    
}