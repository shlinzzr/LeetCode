// https://leetcode.com/problems/minimum-number-game

class Solution {
    public int[] numberGame(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n: nums){
            list.add(n);
            
        }
        
         List<Integer> arr = new ArrayList<>();
        
        Collections.sort(list);
        
        for(int i=0; i<list.size() ; i+=2){
            int a = list.get(i);
            int b = list.get(i+1);
            
            arr.add(b);
            arr.add(a);
        }
        
        
        int[] res = new int[nums.length];
        
        for(int i=0; i<nums.length;i++){
            res[i]=arr.get(i);
        }
        
        return res;
        
    }
}