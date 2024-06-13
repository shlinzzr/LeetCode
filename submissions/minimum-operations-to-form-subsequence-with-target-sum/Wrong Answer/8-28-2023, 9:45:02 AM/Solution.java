// https://leetcode.com/problems/minimum-operations-to-form-subsequence-with-target-sum

class Solution {
    public int minOperations(List<Integer> nums, int target) {
//         int siz = nums.size();
        
        
//         String need_str = Integer.toBinaryString(target);  //100000
//         char[] arr = need_str.toCharArray(); 
//         reverse(arr); // 000001
//         List<Integer> need = new ArrayList<>();
//         for(int i=0; i<arr.length; i++){
//             if(arr[i]=='1')
//                 need.add(i);
//         }
        
        
//         int[] have = new int[32];
//         for(int n : nums){
//             String s = Integer.toBinaryString(n); //100000
//             have[s.length()-1]++:
//         }
        
        
//         for(int i=0; i<31 i++){
            
//             if(have[i]<
            
            
//         }
        
//         // 12 1100
        
//         // need 2,3
//         // have 1 1 2 32 => 0 1 5
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int sum = 0;
        for(int n : nums){
            sum+=n;
            pq.offer(n);
        }
        
        if(sum<target)
            return -1;
        
        
        int ans = 0;
        while(target>0){
            
            int p = pq.poll();
            sum-=p;
            
            
            if(p<=target){
                target-=p;
                
            }else{
                sum+=p;
                ans++;
                pq.offer(p/2);
                pq.offer(p/2);
            }
            
            
            if(pq.isEmpty() && target!=0){
                return -1;
            }

            
            
        }
        
        return ans;
    }
    
        
        
        
        
        
    
    
//     private void reverse(char[] arr){
        
//         int len = arr.length;
        
//         for(int i=0; i<len/2; i++){
         
//             char tmp = arr[i];
//             arr[i] = arr[len-i-1];
//             arr[len-i-1]=tmp;
            
//         }
        
        
//     }
    
}