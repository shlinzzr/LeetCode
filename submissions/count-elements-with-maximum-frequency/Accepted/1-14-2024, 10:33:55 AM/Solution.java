// https://leetcode.com/problems/count-elements-with-maximum-frequency

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max= 0 ;
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
            if(map.get(n)>max){
                list=new ArrayList<>();
                list.add(n);
                max=map.get(n);
            }else if(map.get(n)==max){
                list.add(n);
            }
        }
        
        
        return list.size()*max;
        
        
    }
}