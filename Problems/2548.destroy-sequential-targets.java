// https://leetcode.com/problems/destroy-sequential-targets

class Solution {
  public int destroyTargets(int[] A, int space) {
      int res = Integer.MAX_VALUE;
      
      HashMap<Integer, Integer> map = new HashMap<>();
      for(int a : A ){
          map.put(a%space, map.getOrDefault(a%space, 0)+1);
      }
      
      int max = Collections.max(map.values());
      for(int a: A){
          
          if(map.get(a%space)==max)
              res = Math.min(res, a);
          
      }
      
      
      return res;
      
      
    }
}
