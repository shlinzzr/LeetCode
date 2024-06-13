// https://leetcode.com/problems/sliding-subarray-beauty

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int len = nums.length;

        int[] res = new int[len-k+1];

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt1=0, cnt2=0;
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        int st =0;
        for(int ed=0; ed<len; ed++){

            if(cnt1<x){
                map1.put(nums[ed], map1.getOrDefault(nums[ed], 0)+1);
                cnt1++;
            }else{

                if(nums[ed] > map1.lastKey()){
                    map2.put(nums[ed], map2.getOrDefault(nums[ed], 0)+1);
                    cnt2++;
                }else{
                    map1.put(nums[ed], map1.getOrDefault(nums[ed], 0)+1);
                    cnt1++;


                    // move map1.last. to map2
                    int last = map1.get(map1.lastKey());

                    if(cnt1-last>=x){
                        map2.put(map1.lastKey(), last);
                        cnt2+=last;
                        map1.remove(map1.lastKey());
                        cnt1-=last;
                    }

                }

            }

            
            if(ed<k-1) continue;


//               System.out.println("map1.size"+ cnt1);
//             for(int a : map1.keySet()){
//               System.out.print( a + " :" + map1.get(a) + ", ");
//             }
//             System.out.println();

// System.out.println("map2.size"+ cnt2);
//             for(int a : map2.keySet()){
//               System.out.print( a + " :" + map2.get(a) + ", ");
//             }
//             System.out.println();
//             System.out.println();


//              System.out.println(" map1.lastKey()="+ map1.lastKey());
            if(map1.lastKey()<0)
                res[st] = map1.lastKey();


            if(nums[st]>map1.lastKey()){
                map2.put(nums[st], map2.getOrDefault(nums[st],0)-1);    
                if(map2.get(nums[st])<=0)
                    map2.remove(nums[st]);
                cnt2--;
            }else{
                map1.put(nums[st], map1.getOrDefault(nums[st],0)-1);    
                cnt1--;
                if(map1.get(nums[st])<=0)
                    map1.remove(nums[st]);

                if(cnt1<x && cnt2>0){
                     int first =  map2.get(map2.firstKey());
                     map1.put(map2.firstKey(), first);
                     cnt1 += first;
                     cnt2 -= first;
                     map2.remove(map2.firstKey());
                }
            }

            st++;
          
        
        

        }

        return res;

    }


    private int getXthValue(TreeMap<Integer, Integer> map, int x){

        int cnt = 0;
        for(int k : map.keySet()){
            if(k<0){
                cnt += map.get(k);
                if(cnt>=x)
                    return k;

            }else{
                return 0;
            }
        }

        return 0;
    }
}