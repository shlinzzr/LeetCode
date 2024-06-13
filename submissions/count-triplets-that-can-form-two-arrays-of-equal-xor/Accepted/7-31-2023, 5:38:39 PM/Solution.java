// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        
        int len = arr.length;
        
        int[] prexor = new int[len];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // val, List<idx>
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        
        int xorsum = 0;
        int ret = 0;
        for (int k=0; k<arr.length; k++)
        {
            xorsum ^= arr[k];
            for (int i: map.getOrDefault(xorsum, new ArrayList<>()))
                // ret += Math.max(0, k-(i-2)+1);
                ret+=k-i-1;
            
            map.putIfAbsent(xorsum, new ArrayList<>());
            map.get(xorsum).add(k);
        }
        return ret;
        
        //  unordered_map<int,vector<int>>Map;
        // Map[0].push_back(-1);
        // int xorsum = 0;
        // int ret = 0;
        // for (int k=0; k<arr.size(); k++)
        // {
        //     xorsum ^= arr[k];
        //     for (int i: Map[xorsum])
        //         ret += max(0, k - i -1);
        //     Map[xorsum].push_back(k);
        // }
        // return ret;
        
        
        
        
        
        
// // XXX   [ X X X X X X ][X X X X]  XXX
//       // a=i^  ...^ j-1, j ... k
        
//         // find arr where xor ==0;
        
//         int len = arr.length;
        
//         int res = 0;
        
//         for(int i=0; i<len; i++){
            
//             int xor = arr[i];
            
//             for(int j=i+1; j<len; j++){
                
//                 xor ^= arr[j];
//                 if(xor==0){
//                     res+= (j-i);// 總共有(j-i+1)個element, 切成多份且每份不為0個element有幾種切法？ => (j-i)種
//                 }
//             }
//         }
        
//         return res;
        
        
    }
}