// https://leetcode.com/problems/move-zeroes

void moveZeroes(int* nums, int numsSize) {
    
    for(int i = 0;i<numsSize; i++)
    {
        if(nums[i]==0);
        for(int j = i+1 ; j <numsSize; j++)
            if(nums[j]!=0){
              int tmp =nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
              break;
            }
    }
}