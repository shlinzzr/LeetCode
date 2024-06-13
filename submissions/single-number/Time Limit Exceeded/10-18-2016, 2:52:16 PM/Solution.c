// https://leetcode.com/problems/single-number


int singleNumber(int* nums, int numsSize) {
    int tmp,ans;
    for(int i=0;i<numsSize; i++)
    {
        tmp = nums[i];
       
        for(int j=0;j<numsSize;j++)
        {
           if (tmp == nums[j] && i!=j){
                break;
            }
            else if (j == numsSize-1){
                //printf("%d",tmp);
                ans = tmp;
                return ans;
            }
        }
        
    }
    return ans;
}


/*
//O(n) solution using XOR
int singleNumber(int* nums, int numsSize) {
    int result = 0;
    for (int i = 0; i<numsSize; i++)
    {
		result ^=nums[i];
    }
	return result;
}
*/