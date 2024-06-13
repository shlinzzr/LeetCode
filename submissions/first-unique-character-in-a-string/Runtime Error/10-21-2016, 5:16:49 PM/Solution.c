// https://leetcode.com/problems/first-unique-character-in-a-string

int firstUniqChar(char* s) {
    int n = strlen(s);
    int *arr = malloc(n*sizeof(char));
    
    
    for(int i=0;i<n;i++)
    {
        arr[*(s+i)-'a'] = s[i];
    }
    
    for(int i=0;i<n;i++)
    {
        if(arr[i] == 0)
        return i;
    }
    
    return -1;
}