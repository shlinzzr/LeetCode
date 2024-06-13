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
        
        int diff =0;
        for(int n : nums){
            if(n!=maxNum)
                diff++;
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

        // System.out.println(maxNum + " " + diff+ " "+ nextDiff + " " + prevDiff);
        
        int res =0;
        int target = maxNum*len;
        while(diff>0){
             // if(nextDiff >= prevDiff){
            
            int[] temp = new int[len];
            for(int i=0; i<len; i++){
                temp[i]=arr[i];
            }
            
                for(int i=0; i<len; i++){
                    if(i==len-1){
                        if(temp[len-1]==maxNum && temp[0]!=maxNum){
                            // sum-=arr[0];
                            // sum+=maxNum;
                            arr[0]=maxNum;
                            diff--;
                        }
                            
                        
                    } else if(temp[i]==maxNum && temp[i+1]!=maxNum){
                        // sum-=arr[i+1];
                        // sum+=maxNum;
                        arr[i+1]=maxNum;
                        diff--;
                    }else{
                        temp[i]=arr[i];
                    }
                }
            
            
            //     for(int ar : arr){
            //         System.out.print(ar+",");
            //     }
            // System.out.println();
            
            // }else{
                
                 for(int i=len-1; i>=0; i--){
                     
                     if(i==0){
                         if(temp[0]==maxNum && temp[len-1]!=maxNum){
                             // sum-=arr[len-1];
                             // sum+=maxNum;
                             arr[len-1] = maxNum;
                             diff--;
                         }    
                      }else if(temp[i]==maxNum && temp[i-1]!=maxNum){
                             
                             // sum-=arr[i-1];
                             // sum+=maxNum;
                             arr[i-1]=maxNum;
                             diff--;
                     }else{
                         temp[i]=arr[i];
                     }
                     
                 }
                 
                 
            //     for(int ar : arr){
            //         System.out.print(ar);
            //     }
            // System.out.println();

            // }     
            
            res++;
        }
        
       
        return res;
        
        
        
        
    }
}