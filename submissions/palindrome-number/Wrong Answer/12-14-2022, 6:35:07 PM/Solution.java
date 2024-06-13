// https://leetcode.com/problems/palindrome-number

class Solution {
    public boolean isPalindrome(int x) {
        List<Integer> list = new ArrayList<>();
        while(x!=0){
            list.add(x%10);
            x/=10;
        }
        
        int st=0, ed= list.size()-1;
        while(st<ed){
            if(list.get(st)!=list.get(ed))
                return false;
            st++;
            ed--;
        }
        return true;
        
            
        
        
    }
}