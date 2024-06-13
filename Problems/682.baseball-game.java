// https://leetcode.com/problems/baseball-game

class Solution {
    public int calPoints(String[] operations) {


        List<Integer> list = new ArrayList<>();

        for(String s : operations){

            // boolean sign = s.charAt(0)=='-' ;
            char ch = s.charAt(0);

            if(ch=='+'){
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
            }else if(ch=='C'){
                list.remove(list.size()-1);
            }else if(ch=='D'){
                list.add(2* list.get(list.size()-1));
            }else {
                list.add(Integer.parseInt(s));
            }
        }

        int sum = 0 ;
        for(int n : list){
            sum+= n;
        }

        return sum ;
        

        //["5","-2","-4","9",5,"14"]

// 
        // [ ] 
    }
}