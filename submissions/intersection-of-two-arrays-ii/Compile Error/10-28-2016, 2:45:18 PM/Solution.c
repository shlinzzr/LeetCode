// https://leetcode.com/problems/intersection-of-two-arrays-ii

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */

 //先Sort
int* intersect(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    
    nums1=BubbleSort(nums1, nums1Size);
    nums2=BubbleSort(nums2, nums2Size);
    
    int n = (nums1Size>nums2Size? nums1Size:nums2Size);
    int arr[] = malloc(n * sizeof(int));
    
   // for(int i=0; i<nums2Size; i++)
   //     printf("%d ", *(nums2+i));
    
   int cnt=0, i=0, j=0;
   while(i<nums1Size && j<nums2Size)
   {
            if(nums1[i] > nums2[j])
                j++;
            else if(nums1[i] < nums2[j])
                i++;
            else  if(nums1[i]==nums2[j])
            {
                printf("%d ", nums1[i]);
                arr[cnt] = nums1[i];
                i++;
                j++;
                cnt++;
            }
    }
    
    return arr;
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
