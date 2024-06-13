// https://leetcode.com/problems/the-score-of-students-solving-math-expression

class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int len = s.length();

       int correct = leetcode227calculate(s);
        
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
    
    
     public int leetcode227calculate(String s) {
        s = s.trim();
        
        int len = s.length();
        
        
        Stack<Integer> ist = new Stack<>();
        Stack<Character> ost = new Stack<>();
        char op='+';
        int num = 0;

        
        
        for(int i=0; i<len ; i++){
            
            char ch = s.charAt(i);
            
            if(ch ==' ')
                continue;
            
            if(Character.isDigit(ch)){
                
                num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + (s.charAt(i+1)-'0');
                    i++;
                }
                
                // ist.push(num);
                
            }
            
            if(s.charAt(i)!=' ' || i==len-1){
                
                if(op=='+'){
                    ist.push(num);
                    
                }else if(op=='-')
                    ist.push(-num);
                    
                else if(op=='*'){
                    ist.push(ist.pop()*num);
                    
                }else if(op=='/'){
                    ist.push(ist.pop()/num);
                }
                op=ch;
                num=0;
            }
        }
        
        int total = 0;
        
        for(int i : ist){
            total+=i;
        }
        
        return total;
        
        
        
    }
    
}