// https://leetcode.com/problems/last-stone-weight

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        List<Integer> list = new ArrayList<>();
        for(int s: stones){
            list.add(s);
        }
        
        
        while(list.size()>1){
            
            List<Integer> forloop = new ArrayList<>(list);
            list.clear();
            
            int max=0, max2=0;
            for(int s : forloop){
                if(s>max){
                    max=s;
                    continue;
                }

                if(s>max2){
                    max2=s;
                    continue;
                }

                list.add(s);

            }
            System.out.println(max + " "+ max2);
            int del =Math.abs(max-max2);
            if(del!=0)
                list.add(del);
        }
        
        return list.get(0);
        
        
        
        
        
    }
}