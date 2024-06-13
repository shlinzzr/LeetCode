// https://leetcode.com/problems/fizz-buzz

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
*/
char** fizzBuzz(int n, int* returnSize) {
    
    char **arr = (char **)malloc( n*sizeof(char *) );
    
    for(int i=0;i<n;i++ )
    {
        arr[i] = (char *)malloc( 16*sizeof(char) ); //为每行分配m个数据空间
    }
    
    for(int i=0; i<n; i++){
        if((i+1)%15==0)
            *(arr+i) = "FizzBuzz";
        else if((i+1)%3==0)
            *(arr+i) = "Fizz";
        else if ((i+1)%5==0)
            *(arr+i) = "Buzz";
        else 
          sprintf(*(arr+i), "%d", i+1);
            
    }
    *returnSize=n;
    return arr;
} 

/*

//http://blog.csdn.net/xpqhqy1314/article/details/52829322
char** fizzBuzz(int n, int* returnSize) {
    char **temp;
    int i=0,m=16;
    temp=(char **)malloc( n*sizeof(char *) ); //分配n行
    for(i=0;i<n;i++ )
    {
        temp[i]=(char *)malloc( m*sizeof(char) ); //为每行分配m个数据空间
    }

    for(i=0;i<n;i++)
    {
        if((i+1)%15==0)
        *(temp+i)="FizzBuzz";
        else if((i+1)%3==0)
        *(temp+i)="Fizz";
        else if((i+1)%5==0)
        *(temp+i)="Buzz";
        else
        sprintf(*(temp+i), "%d", i+1);
    }

    *returnSize=n;
    return temp;
}

*/



