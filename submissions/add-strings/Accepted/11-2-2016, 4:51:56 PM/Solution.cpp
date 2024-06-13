// https://leetcode.com/problems/add-strings

class Solution {
   public:
    string addStrings(string num1, string num2) {
        
    int i=num1.size()-1,j=num2.size()-1,carry=0;
    string res="";
    while(i>=0||j>=0)
    {
        if(i>=0) carry+=num1[i--]-'0';
        if(j>=0) carry+=num2[j--]-'0';
        res=to_string(carry%10)+res;
        carry/=10;
        //cout<<carry<<endl;
    }
    return carry?"1"+res:res;
}
};