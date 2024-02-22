// https://leetcode.com/problems/minimum-cost-to-make-array-equal

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int len = nums.length;
        
        Tuple[] arr = new Tuple[len];
        for(int i=0; i<len; i++){
            Tuple t = new Tuple(nums[i], cost[i]);
            arr[i] = t;
        }
        
        Arrays.sort(arr, (a,b)-> a.num-b.num);
        // assume avg = k;
        // total +=.  cost[i]*(k-nums[i])  find minimum
        
        // [1,3], [2,3]
        // [1] avg=1 cost=0;
        // [1,3] avg=3 cost=4
        // st ed
        
        
        // solution 2 :好孩子不要學 sum[0, i](xi-p) is median of totalCost
        
        long totalCost = 0; 
        for(int i=0; i<len; i++){
            totalCost+= cost[i];
        }
        
        int k=0;
        long currCost = 0;
        for(int i=0; i<len; i++){
            currCost += arr[i].cost;
            
            if(currCost>=totalCost*1.0/2){
                k=i;
                break;
            }
        }
        
        long res = 0;
        for(int i=0; i<len; i++){
            
            res += Math.abs(arr[i].num-arr[k].num)*(long)arr[i].cost;
        }
        
        return res;

        
        
        
        
        
        // solution 1:
//         long[] costLeft = new long[len];
        
        
//         long costSum = 0;
//         for(int i=0; i<len; i++){
//             costLeft[i] = (i==0)? 0 : costLeft[i-1] + costSum*(arr[i].num-arr[i-1].num);
//             costSum+=arr[i].cost;
//         }
        
        
//         long[] costRight = new long[len];
//         costSum = 0;
//         for(int i=len-1; i>=0; i--){
//             costRight[i] = (i==len-1)? 0 : costRight[i+1] + costSum*(arr[i+1].num-arr[i].num);
//             costSum+=arr[i].cost;
//         }
        
//         long min = costLeft[0] + costRight[0];
//         for(int i=1; i<len; i++){
//             min = Math.min(min, costLeft[i] + costRight[i]);
//         }
        
//         return min;
    }
    
    
    class Tuple{
        int num;
        int cost;
        public Tuple(int num, int cost){
            this.num = num;
            this.cost = cost;
        }
    }
}