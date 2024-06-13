// https://leetcode.com/problems/add-binary

class Solution{
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i>=0 || j>=0){
            int sum = carry;
            if(i>=0 && a.charAt(i) == '1'){
                sum += a.charAt(i) - '0';
            }
            if(j>=0 && b.charAt(j) == '1'){
                sum += b.charAt(j) - '0';
            }

            sb.insert(0, (sum%2));
            carry = sum/2;
            i--;j--;
        }
        if(carry>0){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}