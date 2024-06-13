// https://leetcode.com/problems/maximum-units-on-a-truck

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1,b2)->Integer.compare(b2[1],b1[1]));
        int max = 0;
            
        for(int[] type: boxTypes){

            int num = type[0];
            int unit = type[1];
            if(truckSize>0){
                
                if(truckSize<num){
                    num = truckSize;
                }
                max+=unit*num;
                truckSize-=num;
                
            }else{
                break;
            }
        }
        
        return max;
            
            
            
            
        
    }
}