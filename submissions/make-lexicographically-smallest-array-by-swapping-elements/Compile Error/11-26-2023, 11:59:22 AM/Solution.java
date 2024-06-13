// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int len = nums.length;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>(); // val, key
        
        for(int i=len-1; i>=0; i--){
            int n = nums[i];
            
            Integer flor = map.floorKey(n);
            if(flor!=null && flor>n-limit){
                nums[i] = flor;
                nums[map.get(flor)]=n;
                map.put(flor, i);
                map.put(n, map.get(ceil));
                
                // 62 60
                // 60 63 62
                
                int key =  map.get(ceil);// 60.idx
                Integer flor = map.floorKey(n+limit); //62
                while(map.floorKey(n+limit)!=null && map.floorKey(n+limit)>n){
                    nums[key] = map.floorKey(n+limit);
                    nums[map.get(map.floorKey(n+limit))] = n;
                    n= map.get(map.floorKey(n+limit));
                     
                }
                
                
                
            }else{
                
            
                map.putIfAbsent(n,new ArrayList<>());
                map.get(n).add(0,i);
            }           
        }
        
        return nums;
        
        
        
//         int[] res = new int[len];
//         int idx = 0;
        
//         Stack<Integer> st = new Stack<>();
//         Stack<Integer> st2 = new Stack<>();
        
//         for(int n : nums){
            
//             while(!st.isEmpty() && Math.abs(st.peek()-n)<=limit && st.peek()>n){
//                 st2.push(st.pop());
//             }
            
            
//             st.push(n);
            
//             while(!st2.isEmpty()){
//                 st.push(st2.pop());
//             }
//         }
        
//         for(int i : st){
//             res[idx++]=i;
//         }
        
//         return res;
    }
}

//[1,4,5,3,9,8]

// 1 3 4 5
    
// 5 4

//[1,60,34,84,62,56,39,76,49,38]
// 4
// [1,60,34,84,62,56,39,76,49,38]
// [1,56,34,84,60,62,38,76,49,39]


//56 34 84 60 62 38 76 49 39
// 

// [1,60,34,84,62,56,39,76,49,38]8

