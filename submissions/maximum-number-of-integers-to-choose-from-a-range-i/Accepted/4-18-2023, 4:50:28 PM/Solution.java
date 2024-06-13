// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int b : banned){
            set.add(b);
        }
        
        int sum=0;
        int cnt=0;
        
        for(int i=1; i<=n; i++){
            
            if(set.contains(i))
                continue;
            
            sum+=i;
            if(sum>maxSum)
                break;
            
            set.add(i);
            cnt++;
            
            
            
           
        }
        
        return cnt;
        
    }
}