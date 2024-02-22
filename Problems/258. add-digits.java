// https://leetcode.com/problems/add-digits

class Solution {
    public int addDigits(int num) {
        int sum = 0;
        
        while(num>0){
            sum+=num%10;
            num/=10;
            
            if(num==0){
                num=sum;
                sum=0;
                if(num<10)
                    return num;
            }
    
        }
            

        
        return sum;
    }
}