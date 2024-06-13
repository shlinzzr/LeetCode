// https://leetcode.com/problems/the-score-of-students-solving-math-expression

class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        StringBuilder numbers = new StringBuilder();
        StringBuilder operators = new StringBuilder();
        int len = s.length();
        
        for(int idx = 0;idx<len;idx++){
            char ch = s.charAt(idx);
            if(ch=='+'||ch=='*') operators.append(ch);
            else numbers.append(ch);
        }
        
        len = numbers.length();
        
        HashSet<Integer>[][] dp = new HashSet[len][len]; 
        for(int row =0;row<len;row++){
            for(int col =0;col<len;col++) dp[row][col] = new HashSet();
        }
        
        //dp[start][end] is a HashSet, which stores all the possible values of the    
        //expression from index start to end 
        
        for(int gap = 0;gap<len;gap++){ // gap between start and end
            for(int start = 0 , end =gap;end<len;start++,end++){
                if(gap==0){
                    dp[start][end].add(numbers.charAt(start)-'0');
                }else{
                    for(int operatorIdx =start;operatorIdx<=end-1;operatorIdx++){
                        HashSet<Integer> leftSet = dp[start][operatorIdx];
                        HashSet<Integer> rightSet = dp[operatorIdx+1][end];
                        char operator = operators.charAt(operatorIdx);
                        // cross left and right evaluations and 
                        // evaluate current expression
                        for(int leftEval : leftSet){
                            for(int rightEval : rightSet){
                                 if(operator=='+'){
                                     int eval = leftEval+rightEval; 
                                     // answer belongs in [0,1000] (constraints)
                                     // pruning it 
                                     if(eval>1000) continue; 
                                     dp[start][end].add(eval);
                                 }else if(operator=='*'){
                                     int eval = leftEval*rightEval; 
                                     if(eval>1000) continue; 
                                     dp[start][end].add(eval);
                                 }
                            }
                        }
                    }
                }
            }
        }
        
        // all evaluations are in dp[0][n-1]
        HashSet<Integer> evaluations = dp[0][len - 1];
        
        int correctAns = leetcode227calculate(s);
        
        int totalScore =0;
        for(int answer : answers){
            if(answer==correctAns) totalScore+=5;
            else if(evaluations.contains(answer)) totalScore+=2;
        }
        
        return totalScore;
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