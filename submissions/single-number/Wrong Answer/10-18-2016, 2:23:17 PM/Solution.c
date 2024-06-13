// https://leetcode.com/problems/single-number

int singleNumber(int* nums, int numsSize) {
    
    int tmp,ans;
    for(int i=0;i<numsSize; i++)
    {
        tmp = nums[i];
        //printf("%d",tmp);
        for(int j=0;j<numsSize;j++)
        {
           if (j == numsSize-1)
               ans = tmp; 
            else if(i==j && numsSize!=1)
                continue;
            else if (tmp == nums[j])
                break;
            
        }
        
    }
    return ans;
}