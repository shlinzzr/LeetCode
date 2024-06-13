// https://leetcode.com/problems/longest-palindrome

//char *s => a = 65
//  *s - 'a' = 0

int longestPalindrome(char* s) {

    int result,tmp,cnt = 0;
    int n = strlen(s);
    int *arr = malloc(52*sizeof(int));  //a-z A-Z
    for(int i=0;i<n;i++)
    {
      int num = *(s+i) -'a';
      printf("%d ", num);
      arr[ num ]++;
    }
    
    for(int j=0;j<52;j++)
    {
        bool haveodd= false;
        if(arr[j]%2==1){
            haveodd =true;
            cnt++;
        }
    }
    
    if(haveodd) return n-cnt+1;
    
    return n;
} 
/*    
    while(*s)
    {
        printf("s=%d ",*s-'a'+1);
        result=result^(*s++ -'a' + 1);
        
        if (result!=0)
            cnt++;
        else 
            cnt--;
    }
    if (n==1) return 1;
    //子問題是  1.到底是自己(return n)或是由小的k個binary組成(return n-k)  1.變成binary會有幾位(求K)
    //   ccc or ccab  => 333 or 3312
    
    
    if(result!=0) 
    if(cnt==1) return n;   
    else return n-k;
    
}
*/

