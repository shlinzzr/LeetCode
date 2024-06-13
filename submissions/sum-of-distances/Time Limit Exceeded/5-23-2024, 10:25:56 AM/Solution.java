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

        for(int k : map.keySet()){
            List<Integer> list = map.get(k);
            if(list.size()==1){
                res[list.get(0)]=0;
            }else{

                for(int j=0; j<list.size(); j++){
                    List<Long> rt = getSum(list);
                    res[list.get(j)] = rt.get(j);
                }
            }
        }

        return res;
        
    }

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
            res.add ( list.get(i)*i- presum[i] + sufsum[i]- (list.get(i)*(len-i-1)));
        }


        return res;

    }
}