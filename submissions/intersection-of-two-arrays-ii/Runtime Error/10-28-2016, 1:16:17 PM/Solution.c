// https://leetcode.com/problems/intersection-of-two-arrays-ii

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* intersect(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    
    int cnt = 0;
    for(int i=0; i<nums1Size; i++)
    {
        for(int j=0; j<nums2Size; j++)
        {
            if(nums1[i]==nums2[j])
            {
                returnSize[cnt] = nums1[i];
                nums2[j]=11111111111111111111111111111111;
                cnt++;
            }
            
        }
        
    }
    return returnSize;
}