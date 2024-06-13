// https://leetcode.com/problems/reverse-vowels-of-a-string


/*
// 6ms 11.11%
char* reverseVowels(char* s) {
    int len = strlen(s), i = 0, j =len-1;
    char tmp;

    while(i < j)
    {
        while(i < j && s[j] != 'a' && s[j] != 'e' && s[j] != 'i' && s[j] != 'o' && s[j] != 'u' && s[j] != 'A' && s[j] != 'E' && s[j] != 'I' &&     s[j] != 'O' && s[j] != 'U')
        {
            j--;
        }
        
        while(i < j && s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' && s[i] != 'A' && s[i] != 'E' && s[i] != 'I' &&     s[i] != 'O' && s[i] != 'U')
        {
            i++;
        }
        if(i < j)
        {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        j--;
        i++;
    }
return s;
}
*/

char* reverseVowels(char* s) {
    int n = strlen(s);
    char tmp;
    char charr[n+1];
    int index[n+1];
    
    int cnt = 0 ;
    for(int i=0;i<n;i++)
    {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i'||s[i] == 'o' || s[i] == 'u' ||s[i] == 'A' || s[i] == 'E' || s[i] == 'I'||s[i] == 'O' || s[i] == 'U'){
            charr[cnt] = s[i];
            index[cnt] = i;
            cnt++;
        }
    }
    // printf("%c %d %d", charr[1] ,index[1], cnt);
 
    for (int i=0;i<cnt;i++)
    {
        s[index[i]] = charr[cnt-i-1];
    }
    
    return s;
}