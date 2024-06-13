// https://leetcode.com/problems/find-the-difference

char findTheDifference(char* s, char* t) {
    int n = strlen(s);
    int i;
    for(i=0; i<n; i++)
    {
        if(s[i] == t[i])
            continue;
        else 
            break;
    }
    return t[i];
}