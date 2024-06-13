// https://leetcode.com/problems/decode-string

class Solution {
    public String decodeString(String s) {

        int len = s.length();

        Stack<StringBuilder> sst = new Stack<>();
        Stack<Integer> ist = new Stack<>();
        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            char ch = arr[i];

            if(ch==' ') continue;

            if(Character.isDigit(ch)){
                int num = ch-'0';
                while(i+1<arr.length && Character.isDigit(arr[i+1])){
                    num = num*10+ (arr[i+1]-'0');
                    i++;
                }
                ist.push(num);
            }else if(ch=='['){
                sst.push(sb);
                sb= new StringBuilder();

            }else if(ch==']'){
                int loop = ist.pop();
                StringBuilder tmp = sst.pop();
                for(int j=0; j<loop; j++){
                    tmp.append(sb);
                }
                sb = tmp;
            }else{
                sb.append(ch);
            }


        }
        return sb.toString();
        
    }
}