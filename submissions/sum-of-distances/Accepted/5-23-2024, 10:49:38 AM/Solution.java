// https://leetcode.com/problems/sum-of-distances

class Solution {
    public long[] distance(int[] nums) {
        
        // 1 : 0 2 3
        // 3 : 1
        // 2 : 
        int len = nums.length;
        long[] res = new long[len];

        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0; i<len; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }


        // by huifeng, one-pass solution
        for(Map.Entry<Integer, List<Integer>> en : map.entrySet()){
            int val = en.getKey();
            List<Integer> list = en.getValue();
            long sum = 0;
            for(int i=0; i<list.size(); i++){
                sum += list.get(i) - list.get(0);
            }
            res[list.get(0)] = sum;
            for(int i=1; i<list.size(); i++){
                sum +=  (list.get(i)-list.get(i-1))*i;
                sum -=  (list.get(i)-list.get(i-1))*(list.size()-i) ;
                res[list.get(i)] = sum ;
            }
        }


        // // 不知道錯在哪欸
        // for(int k : map.keySet()){
        //     List<Integer> list = map.get(k);
        //     if(list.size()<=1){
        //         res[list.get(0)]=0;
        //     }else{
        //         List<Long> rt = getSum(list);

        //         System.out.println(rt);
        //         for(int j=0; j<list.size(); j++){
        //             res[list.get(j)] = rt.get(j);
        //         }
        //     }
        // }

        return res;
        
    }


     // // 不知道錯在哪欸
    private List<Long> getSum(List<Integer> list) {

        List<Long> res = new ArrayList<>();

        int len = list.size();

        long[] presum = new long[len];
        long[] sufsum = new long[len];
        for(int i=0; i<len; i++){
            presum[i] = list.get(i) + (i==0? 0 : presum[i-1]);
            int idx = len-1-i;
            sufsum[idx] = list.get(idx) + (idx==len-1 ? 0 : sufsum[idx+1]);
        }

        // 1 : 0 2 3
        // p   0 2 5
        // s.  5 5 3

        //i=0 : 
//        5
        // i=1
        // 2*2-2 + 5-(2*2)


        for(int i=0; i<len; i++){
            res.add( list.get(i)*(i+1)-presum[i] + sufsum[i] - list.get(i)*(len-i));
        }


        return res;

    }
}