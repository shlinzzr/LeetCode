// https://leetcode.com/problems/verbal-arithmetic-puzzle

class Solution {

    HashMap<Character, Integer> map = new HashMap<>();
    boolean[] seen = new boolean[10];

    public boolean isSolvable(String[] words, String result) {
        List<String> list = new ArrayList<>();
        for(String w : words){
            if(w.length()>result.length()) return false;
            list.add(new StringBuilder(w).reverse().toString());
        }
        result = new StringBuilder(result).reverse().toString();
       
        return helper(list, result, 0, 0, 0);

    }

    private boolean helper(List<String> list, String result, int i, int j, int sum){

        if (j==result.length())
        {
            if (sum!=0) {
                 return false;
            }
            if (result.length()>1 && map.get(result.charAt(result.length()-1))==0){
                 return false;
            }

            return true;
        }



        if(i==list.size()){

            if(map.containsKey(result.charAt(j))){ //有用過這個char
                if(map.get(result.charAt(j))!=sum%10){
                    return false;
                }else
                    return helper(list, result, 0, j+1, sum/10);

            }else{ //沒用過這個char

                if(seen[sum%10]) return false; //但數字被用掉了

                map.put(result.charAt(j), sum%10);
                seen[sum%10]=true;
                if(helper(list, result, 0, j+1, sum/10))
                    return true;
                seen[sum%10]=false;
                map.remove(result.charAt(j));

                return false;
            }
        }

        if (j>=list.get(i).length())
        {            
            return helper(list, result, i+1, j, sum);        
        }   

        char ch = list.get(i).charAt(j);
        if(map.containsKey(ch)){

            //consider leading zero
            if( list.get(i).length()>1 && j==list.get(i).length()-1 &&  map.get(ch)==0 )
                return false;

            return helper(list, result, i+1, j, sum+map.get(ch));

        }else{
            for(int d=0; d<=9; d++){
                if(seen[d]) continue;

                if( list.get(i).length()>1 && j==list.get(i).length()-1 && d==0) // consider leading zero
                    continue;
                
                map.put(ch, d);
                seen[d]=true;
                if(helper(list, result, i+1, j, sum+d))
                    return true;
                map.remove(ch);
                seen[d]=false;

            }
            return false;
        }
        // return true;

    }
}