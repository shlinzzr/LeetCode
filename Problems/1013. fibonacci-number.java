// https://leetcode.com/problems/fibonacci-number


  class Solution {
   public int fib(int n) {
        
        if(n<1){
            return n;
        }
        ArrayList<Integer> list=new ArrayList<>(n);
        list.add(0);
        list.add(1);
        for (int i = 2; i <= n; i++) {
            list.add( list.get(i-1)+list.get(i-2));
        }
        return list.get(n);
    }
}
