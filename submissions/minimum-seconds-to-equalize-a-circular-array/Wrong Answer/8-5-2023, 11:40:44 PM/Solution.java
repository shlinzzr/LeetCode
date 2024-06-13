// https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array

class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum =0;
        int max = 0;
        int maxNum = -1;
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
            if(map.get(n)>max){
                max= map.get(n);
                maxNum=n;
            }
            
            sum+=n;
        }
        
        int len = nums.size();
        int nextDiff = 0;
        for(int i=0; i<len-1; i++){
            if(nums.get(i)==maxNum && nums.get(i+1)!=maxNum)
                nextDiff++;
        }
        if(nums.get(len-1)==maxNum && nums.get(0)!=maxNum)
            nextDiff++;
        
        
        int prevDiff=0;
        for(int i=len-1; i>0; i--){
            if(nums.get(i)==maxNum && nums.get(i-1)!=maxNum)
                prevDiff++;
        }
        if(nums.get(0)==maxNum && nums.get(len-1)!=maxNum)
            prevDiff++;
        
        
        int[] arr = new int[len];
        for(int i=0; i<len ;i++){
            arr[i]=nums.get(i);
        }

        
        
        int res =0;
        int target = maxNum*len;
        while(sum != target){
             if(nextDiff >= prevDiff){
                for(int i=0; i<len; i++){
                    if(i==len-1){
                        if(arr[len-1]==maxNum && arr[0]!=maxNum){
                            sum-=arr[0];
                            sum+=maxNum;
                            arr[0]=maxNum;
                        }
                            
                        
                    } else if(arr[i]==maxNum && arr[i+1]!=maxNum){
                        sum-=arr[i+1];
                        sum+=maxNum;
                        arr[i+1]=maxNum;
                    }
                }
            
            }else{
                
                 for(int i=len-1; i>=0; i--){
                     
                     if(i==0){
                         if(arr[0]==maxNum && arr[len-1]!=maxNum){
                             sum-=arr[len-1];
                             sum+=maxNum;
                             arr[len-1] = maxNum;
                             
                         }else if(arr[i]==maxNum && arr[i-1]!=maxNum){
                             
                             sum-=arr[i-1];
                             sum+=maxNum;
                             arr[i-1]=maxNum;
                         } 
                     }
                     
                 }
                 
                 


            }     
            
            res++;
        }
        
       
        return res;
        
        
        
        
    }
}