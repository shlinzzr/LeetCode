// https://leetcode.com/problems/visit-array-positions-to-maximize-score

class Solution {
    public long maxScore(int[] nums, int x) {
        
        
        int len = nums.length;
        
        int cur = nums[0];
        int ops = 0;
        
        boolean even = cur%2==0;
        
        for(int i=1; i<len; i++){
            int n = nums[i];

            //[2,3,6,1,9,2]
            
            if(n%2==0){ // n is even
                
                int nextCur = even? cur+n : cur;
                int nextOps = even? ops : ops+n;
                
                if(nextOps-x > nextCur){
                    int t = nextCur;
                    nextCur = nextOps-x;
                    nextOps = t;
                    even = !even;
                }
                
                cur = nextCur;
                ops = nextOps;
                
            }else{ // n is odd
                
                int nextCur = even? cur : cur+n;
                int nextOps = even? ops+n : ops;
                
                if(nextOps-x >= nextCur){
                    int t = nextCur;
                    nextCur = nextOps-x;
                    nextOps = t;
                    even = !even;
                }
                cur = nextCur;
                ops = nextOps;
            }
            
            System.out.println("i=" + i + " cur="+cur + " ops=" + ops + " even="+even);
            
        }
        
        
        return cur > ops-x ? cur : ops;
    }
}