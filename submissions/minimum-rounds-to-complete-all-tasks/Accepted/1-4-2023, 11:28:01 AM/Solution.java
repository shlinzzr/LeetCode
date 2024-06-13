// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks

class Solution {
    public int minimumRounds(int[] tasks) {
        int len = tasks.length;
        
        // Arrays.sort(tasks);
        
        int cnt =0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        for(int i=0; i<len; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            if(en.getValue()==1)
                return -1;
            
            int val = en.getValue();
            while(val%3!=0){
                val-=2;
                cnt++;
            }
            cnt+=val/3;
        }
        
        return cnt;
            
        
        
    }
}