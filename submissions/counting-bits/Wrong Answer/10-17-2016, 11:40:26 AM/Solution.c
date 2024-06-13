// https://leetcode.com/problems/counting-bits

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
*/
int* countBits(int num, int* returnSize) {
    
    int *arr = malloc((num+1)*sizeof(int));     //int a[num+1];
    int cnt=0;
    
    for(int i = 0; i<num;i++)
    { 
        arr[i]=cnt++;
        for(int bit = 1; i&bit; bit<<=1)
            cnt--;
    }
    *returnSize = num + 1;
    return arr;
}
 
 /*
int* countBits(int num, int* returnSize) {
    //*returnSize = num+1;
    int *arr = malloc(num+1);
    arr[0] = 0;
    for(int i = 1; i < num + 1; i++){
        arr[i]=arr[i&(i-1)]+1;
        printf("%d\n",arr[i]);
    }
    return arr;
}



 40ms

int* countBits(int num, int* returnSize) {
    int* ret = malloc((num + 1) * sizeof(int));
    int i, bit, cnt=0;
    for(i = 0; i <= num; i++) {
        ret[i] = cnt++;
        for(bit = 1; i & bit; bit <<= 1)
            cnt--;
    }

    *returnSize = num + 1;
    return ret;
}

*/














