// https://leetcode.com/problems/majority-element

int majorityElement(int* nums, int numsSize) {
    
   
    int cnt = 0;
    int major;
    
    for(int i=0;i<numsSize; i++)
    {
        if(cnt==0){
           major = nums[i];
           cnt++;
        }
        else if(major == nums[i])
            cnt++;
        else 
            cnt--;
        
    }
    
    
    return  major;
}