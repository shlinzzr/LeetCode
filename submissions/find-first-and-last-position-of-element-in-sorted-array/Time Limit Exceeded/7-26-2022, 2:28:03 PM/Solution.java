// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int st=0, ed= nums.length-1;
        int mid = 0;
        int idx1=-1, idx2=-1;
        while(st<=ed){
            
            
              mid = (st + ed )/2;
            if(nums[mid]==target && (mid==0 || nums[mid-1]!=target)){
                idx1 = mid;
                break;
            
            }else if(nums[mid]<target){  // 1,2,2,4,5,6 tar==2
                st = mid+1;
            }else{
                ed = mid; 
            }
               
            
        }
        
//         mid = (st+ed)/2;
//          if(nums[mid]==target && (mid==0 || nums[mid-1]!=target))
//                 idx1 = mid;
        
        st=0; ed= nums.length-1;
       
        while(st<=ed){
            
             mid = (st + ed )/2;
             // System.out.println("st="+st + ", ed="+ed +",  idx2="+idx2);    
            
            if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]!=target)){
                idx2 = mid;
                break;
            
            }else if(nums[mid]>target){  // 1,2,2,4,5,6 tar==2
                ed = mid;
            }else{
                st = mid+1; 
            }
               
            
            
        }
        
        // mid = (st+ed)/2;
        // if(nums[mid]==target && (mid==nums.length-1 || nums[mid+1]!=target))
        //         idx2 = mid;
        
        
        
        
        return new int[] {idx1, idx2};
    }
}

/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0)
            return new int[]{-1, -1};
        
        
        int st=0, ed = nums.length-1, mid=(st+ed)/2;
        
        while(st<=ed){
            
            mid = (st+ed)/2;
            
            if(nums[mid]==target)
                break;
            else if(nums[mid] < target)
                st = mid+1;
            else{
                ed = mid;
            }
        }
        
        if(nums[mid]!=target)
            return new int[]{-1, -1};
        
        
        
        
        
        int first = mid, last = mid;
        while(first>0 && nums[mid]==nums[first-1]){
            first--;
        }
        
        while(last<nums.length-1 && nums[mid]==nums[last+1]){
            last++;
        }
        
        return new int[]{first, last};
        
    }
}*/