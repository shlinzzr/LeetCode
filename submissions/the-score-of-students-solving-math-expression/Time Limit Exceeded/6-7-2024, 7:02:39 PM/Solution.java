// https://leetcode.com/problems/the-score-of-students-solving-math-expression

class Solution {
    public int scoreOfStudents(String s, int[] ans) {
        // wrong order : 2 pts
        // correct : 5 pts
        // others : 0 pts

        // LC 241  : can get all the wrong order with correct ans
        // others : don't care
        // what is correct ans ? => basic Calculator ? 

        int correct = basicCalculator(s);
        Set<Integer> wo = LCTFO(s, new HashMap<>());

        int sum = 0 ;
        for(int a : ans){
            if(a==correct) sum+=5;
            else if(wo.contains(a)) sum+=2;
        }

        return sum;





    }

    private Set<Integer> LCTFO(String s, Map<String, Set<Integer>> memo) { //leetcode two-four-one

        if(memo.containsKey(s)) return memo.get(s);

        Set<Integer> res = new HashSet<>();
        int len = s.length();

        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) continue;

            Set<Integer> lista = LCTFO(s.substring(0, i), memo);
            Set<Integer> listb = LCTFO(s.substring(i+1, len), memo);
            for(int a : lista){
                for(int b : listb){
                    if(ch=='+') res.add(a+b);
                    else res.add(a*b);
                }
            }
        }

        if(res.isEmpty()) res.add(Integer.parseInt(s));
        memo.put(s, res);
        return res;
    }

    


    private int basicCalculator(String s){
        
        int lv1=0, lv2=1;

        int len = s.length();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    num = num*10 + s.charAt(i+1)-'0';
                    i++;
                }
                lv2 *= num;
            }else if(ch=='+'){
                lv1 += lv2;
                lv2=1;
            }else if(ch=='*'){
                // do nothing
            }
        }

        return lv1 + lv2;
    }
}