// https://leetcode.com/problems/intersection-of-two-arrays-ii

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */

 //先Sort
int* intersect(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    
    nums1=BubbleSort(nums1, nums1Size);
    nums2=BubbleSort(nums2, nums2Size);
    for(int i=0; i<nums1Size; i++)
        printf("%d ", *nums1+i);
        
        
    /*
    int cnt = 0;
    for(int i=0; i<nums1Size; i++)
    {
        for(int j=0; j<nums2Size; j++)
        {
            if(nums1[i] > nums2[j])
                j++;
            else if(nums1[i] < nums2[j])
                i++;
            else  if(nums1[i]==nums2[j])
            {
                returnSize[cnt] = nums1[i];
                i++;
                j++;
                cnt++;
            }
        }
    }*/
    return returnSize;
}


int BubbleSort(int* nums, int numsSize)
{
    int temp;
    for(int i=0; i<numsSize; i++)
    { 
        for(int j=0; j<numsSize-1-i; j++)
        {
             if(nums[j] > nums[j+1])
             {
                temp = nums[j];
                nums[j]= nums[j+1];
                nums[j+1]=temp;
             }
        }
        
    }
    return nums;
}
