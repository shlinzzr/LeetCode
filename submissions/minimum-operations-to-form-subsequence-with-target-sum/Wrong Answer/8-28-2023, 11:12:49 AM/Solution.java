// https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum

class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int sum =0;
        for(int n : nums){
            sum+=n;
        }
        if(sum<target)
            return -1;
        
        // prepare need List
        List<Integer> need= new ArrayList<>();
        String s = Integer.toBinaryString(target);
        char[] tarr = s.toCharArray(); //12 => 1100
        for(int i=0; i<tarr.length;i++ ){
            if(tarr[i]=='1'){
                need.add(tarr.length-i-1);
            }
        }
        
        
        // get have count
        int[] count = new int[32];        
        for(int n : nums){
            int idx = Integer.toBinaryString(n).length()-1; //10
            count[idx]++;
        }
        
        if(need.size()==0)
            return 0;
        
        Collections.sort(need);
        
        
        // from wisdompeak
        int res = 0;
        for (int nd: need)
        {
            
            //search from low
            int lo = 0;
            while (lo<nd)
            {
                count[lo+1] += count[lo] / 2;
                count[lo] %= 2;
                lo++;
            }
            if (lo==nd && count[nd]>0) 
            {
                count[nd] -= 1; // 表示被用掉了
                continue; //如果有找到從下面compose上來的 就不用往上找
            }
            
            
            //往上找 & divide by 2
            
            //找第一個最近的divide
            while (lo<31 && count[lo]==0)
                lo++;
            if (lo==31) return -1;
            count[lo] -= 1; //最高位-1
            for (int k=lo-1; k>=nd; k--) // 其他的一路過來都+1
                count[k]+=1;
            
            res += lo-nd;
        }

        
        
        return res;
    }
}