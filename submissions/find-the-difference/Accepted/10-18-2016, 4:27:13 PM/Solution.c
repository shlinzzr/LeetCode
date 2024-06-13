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

    int sn = strlen(s);
    int tn = strlen(t);
    
    int result=0;
    for(int i=0; i<sn; i++)
    {
        result = result^s[i];
    }
     for(int i=0; i<tn; i++)
    {
        result = result^t[i];
    }
    return (char)result;
}
    
    
    