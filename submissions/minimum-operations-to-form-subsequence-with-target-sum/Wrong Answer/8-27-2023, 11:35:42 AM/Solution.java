// https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum

class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int sum =0;
        for(int n : nums){
            sum+=n;
        }
        
        if(sum<target)
            return -1;
        
        
        String s = Integer.toBinaryString(target);
        System.out.println(s);
        
        char[] tarr = s.toCharArray(); //12 => 1100
        List<Integer> need= new ArrayList<>();

        int max = 0;
        for(int i=0; i<tarr.length;i++ ){
            
            if(tarr[i]=='1'){
                need.add(tarr.length-i-1);
                max = Math.max(max, tarr.length-i-1);
            }
        }
        
        
        
        Set<Integer> set = new HashSet<>();
        
        
        int smax = 0;
        int min = Integer.MAX_VALUE;
        for(int n : nums){
            int idx = Integer.toBinaryString(n).length()-1; //10
            
            // need.remove(idx);
            while(set.contains(idx)){
                idx++;
            }
            
            set.add(idx);
            smax = Math.max(smax, idx);
        }
        
        if(need.size()==0)
            return 0;
        
        if(smax<max)
            return -1;
        
        
        // System.out.println("Set="+set);
        
        
        //  7 5 2
        //  8

        Collections.sort(need);
        
        // System.out.println("need="+need);
        
        int res = 0;
        for(int nd : need){
            // System.out.println("nd="+nd);
            while(!set.contains(nd)){
                set.add(nd);
                nd++;
                res++;
            }
        }
        
        
        
        
        
        
        return res;
    }
}