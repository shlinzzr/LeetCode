// https://leetcode.com/problems/ransom-note

bool canConstruct(char* ransomNote, char* magazine) {
    int len= strlen(ransomNote);
    for(int i=0;i<len;i++)
    {
        if(ransomNote[i] != magazine[i])
           return false;
    }
    return true;
}