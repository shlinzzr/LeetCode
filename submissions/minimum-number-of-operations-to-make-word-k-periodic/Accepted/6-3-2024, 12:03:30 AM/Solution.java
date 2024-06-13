// https://leetcode.com/problems/minimum-number-of-operations-to-make-word-k-periodic

class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {

        Map<String, Integer> map = new HashMap<>();


        int max = 0;
        int len = word.length();
        for(int i=0; i<len; i+=k){

            String sub = word.substring(i, i+k);

            map.put(sub, map.getOrDefault(sub,0)+1);

            if(map.get(sub)>max){
                max = map.get(sub);
            }
        }   


        // ab ab ab ab cd cd cd cd

        int all = len/k;

        return all-max;
        
    }
}