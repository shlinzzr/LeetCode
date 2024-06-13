// https://leetcode.com/problems/valid-anagram

bool isAnagram(char* s, char* t) {
    int sn = strlen(s);
    int tn = strlen(s);
    int *s_arr = malloc(sn * sizeof(int));
    int *t_arr = malloc(tn * sizeof(int));
    
    for(int i=0; i<sn;i++)
    {
        int si = *(s+i)-'a';
        if(si>=0 && si<26)
           s_arr[si]++;
           
        printf("%d ", *(s+i)-'a');
        
    }
    
    for(int i=0; i<tn;i++)
    {
        int ti = *(t+i)-'a';
        if(ti>=0 && ti<26)
           t_arr[ti]++;
        printf("%d ", *(t+i)-'a');
        
    }
    
    for(int i=0; i<26;i++)
    {
        if(s_arr[i] != t_arr[i])
           return false;
    }
    
    return true;
}