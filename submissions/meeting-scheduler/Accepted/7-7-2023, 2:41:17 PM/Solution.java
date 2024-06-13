// https://leetcode.com/problems/meeting-scheduler

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0])); // sort increasing by start time
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0])); // sort increasing by start time
        
        
        int len1= slots1.length;
        int len2 = slots2.length;
        int i=0, j=0;
        
        while(i<len1 && j<len2){
                
            int st = Math.max(slots1[i][0], slots2[j][0]);        
            int ed = Math.min(slots1[i][1], slots2[j][1]);

            if(ed-st>=duration){

                List<Integer> res = new ArrayList<>();

                res.add(st);
                res.add(st +duration);
                return res;


            }else{

                if(slots1[i][1]<slots2[j][1]){
                    i++;

                }else{
                    j++;
                }
            }
        }
        
        return  new ArrayList<>();
    }
}