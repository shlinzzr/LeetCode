// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values

class Solution {
    public int mctFromLeafValues(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int a: arr) list.add(a);
        
        int res = 0;
        while(list.size() != 1) {
            int minIndex = list.indexOf(Collections.min(list));
            
            if(minIndex > 0 && minIndex < list.size()-1)
                res += list.get(minIndex) * Math.min(list.get(minIndex-1), list.get(minIndex+1));   
            
            else if(minIndex == 0)
                res += list.get(minIndex) * list.get(minIndex+1);
            
            else
                res += list.get(minIndex) * list.get(minIndex-1);
            
            list.remove(minIndex);
        }
        return res;
    }
}


/*
sol stack

[ x x1 x2 x x ] [x x x x x]

x1 : [..a]
x2 : [..b]

cost = Math.max(a, b) 小的數字被刪除
其實就是找cost = Math.min(prevGreater, nextGreater);
相消之後不影響後續抉擇



sol dp:

[x x x x x] [x x x x j]
 i.      k

 dp[i][j] = min { max[i][k]*max[k+1][j] + dp[i][k] + dp[k+1][j] } over k : i~j

*/



/* 

a b c

abc + ab is smaller

    c* Math.max(a,b)
    / \
  ab   c 
  /\    
 a  b 


 a * Math.max(b,c)
 /.  \
 a   bc
    / \
   b   c



*/