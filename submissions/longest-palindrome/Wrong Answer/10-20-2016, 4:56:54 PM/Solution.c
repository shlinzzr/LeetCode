// https://leetcode.com/problems/longest-palindrome

int longestPalindrome(char* s) {
    int result = 0;
    int n = strlen(s);
    
    //for(int i=0;i<n;i++)
    //{
    //    result
    //    
    //}
    while(*s)
    {
        printf("s=%d ",*s-'a'+1);
        result^=*s++ -'a' + 1;
    }
    if (result!=0);
    return n-1;
}

//char *s => a = 65
//  *s - 'a' = 0
