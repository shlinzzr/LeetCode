// https://leetcode.com/problems/add-strings

char* addStrings(char* num1, char* num2) {

        int i=strlen(num1),j=strlen(num2),carry=0;
        char *res="";
        while(i>=0||j>=0)
        {
            if(i>=0) carry+=num1[i--]-'0';
            if(j>=0) carry+=num2[j--]-'0';
            
            res = sprintf(res,"%d",carry%10+res);
            carry/=10;
            
        }
        return carry?"1"+res:res;
 

}