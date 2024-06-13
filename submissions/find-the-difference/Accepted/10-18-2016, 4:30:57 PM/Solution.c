// https://leetcode.com/problems/find-the-difference


/*
// XOR 31%
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
*/


char findTheDifference(char* s, char* t) {

    int sn = strlen(s);
    char c = t[sn];
    for(int i=0; i<sn; i++)
    {
        c ^= s[i];
        c ^= t[i];
    }
    return c;
}
    
    