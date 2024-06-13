// https://leetcode.com/problems/reverse-vowels-of-a-string

char* reverseVowels(char* s) {
    int n = strlen(s);
    char tmp;
    char charr[n+1];
    int index[n+1];
    
    int cnt = 0 ;
    for(int i=0;i<n;i++)
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i'||s[i] == 'o' || s[i] == 'u'){
           // printf("%c %d", s[i],i);
            charr[cnt] = s[i];
            index[cnt] = i;
            cnt++;
        }
    }
    // printf("%c %d %d", charr[1] ,index[1], cnt);
 
    for (int i=0;i<cnt;i++)
    {
       // printf("c=%c d=%d i=%d", charr[i] ,index[i], i);
        s[index[i]] = charr[cnt-i-1];
        
    }
    
    return s;
}