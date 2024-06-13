// https://leetcode.com/problems/combination-sum-iv

class Solution {

    // 1. brute-force backtracking : TLE
    // 2. use dfs + memo
    // 3. dp (in the case of low number of target)


    public int combinationSum4(int[] nums, int target) {

        // 1. backtracking  : TLE 
        // return backtracking(nums, target);

        // 2. dfs : 4ms, 7.13%
        // return dfs(nums, target);

        // 3. dp : 2ms, 40.73%
        return dprog(nums, target);
    }

    private int dprog(int[] nums, int target){

        int len = nums.length;

        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=0; i<=target; i++){
            for(int n : nums){
                if(i-n>=0){
                    dp[i] += dp[i-n];
                }
            }
        }
        return dp[target];
    }


    private int dfs(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        return dfsHelper(nums, target, map);
    }

    private int dfsHelper(int[] nums, int target, Map<Integer,Integer> map){
        
        if(target<0) return 0;

        if(map.containsKey(target)) return map.get(target);

        if(target==0) return 1;

        int res= 0 ;

        for(int n : nums){
            int rt = dfsHelper(nums, target-n, map);
            map.put(target-n, rt);
            res += rt;
        }            

        map.put(target, res);
        return res;

    }

    private int backtracking(int[] nums, int target){

        Set<List<Integer>> set = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        backtrackingHelper(nums, target, set, cur);
        return set.size();
        
    }

    private void backtrackingHelper(int[] nums, int target, Set<List<Integer>> set, List<Integer> cur){

        if(target==0){
            set.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i<nums.length; i++){
            int val = nums[i];

            if(target-val>=0){
                cur.add(val);
                backtrackingHelper(nums, target-val, set, cur);
                cur.remove(cur.size()-1);
            }
        }   
    }
}