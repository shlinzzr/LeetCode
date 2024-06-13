// https://leetcode.com/problems/binary-watch

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** readBinaryWatch(int num, int* returnSize) {
    //printf("%d", returnSize);  //221501952
    //printf("%d", *returnSize); // 0
    
    if(num==0)
    {
        int *arr = malloc(sizeof(int *));
        arr[0] = "0:00";
        
        //int arr[0] = "0:00"
        return arr;
    }
    
    
    
    
    
    return *returnSize;
}