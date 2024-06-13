// https://leetcode.com/problems/shifting-letters-ii

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        TreeMap<Integer, Integer> aggMap = new TreeMap<>(); // idx, offset

        for(int[] sh : shifts){

            if(sh[2]==1){
                aggMap.put(sh[0], aggMap.getOrDefault(sh[0], 0)+1);
                aggMap.put(sh[1]+1, aggMap.getOrDefault(sh[1]+1, 0)-1);
            }else{
                aggMap.put(sh[0], aggMap.getOrDefault(sh[0], 0) -1);
                aggMap.put(sh[1]+1, aggMap.getOrDefault(sh[1]+1,0)+1);
            }
        }


        int curr=0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i: aggMap.keySet()){
            curr += aggMap.get(i);
            map.put(i, curr); // idx, offset Agg amount
        }

        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            Integer key = map.floorKey(i);
            if(key==null) continue;
            int offset = map.get(key);

            int v = (arr[i]-'a' + offset+26)%26;
            if(v<0) v+=26; 
            arr[i] = (char) (v+'a');
            

        }

        return new String(arr);

    }
}