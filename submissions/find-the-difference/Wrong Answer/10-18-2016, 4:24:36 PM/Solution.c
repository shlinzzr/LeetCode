// https://leetcode.com/problems/find-the-difference

/*
char findTheDifference(char* s, char* t) {
    int n = strlen(s);
    int i=0;
    for(i=0; i<n; i++)
    {
        if(s[i] == t[i])
            continue;
        else 
            break;
    }
    return t[i];
}
*/

char findTheDifference(char* s, char* t) {

    int n = strlen(s);
    int result=0;
    for(int i=0; i<n; i++)
    {
        result ^= s[i];
    }
     for(int i=0; i<n; i++)
    {
        result ^= t[i];
    }
    return (char)result;
}
    
    
    