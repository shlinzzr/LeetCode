// https://leetcode.com/problems/replace-non-coprime-numbers-in-array

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int len = nums.length;

        Stack<Integer> st= new Stack<>();

        for(int i=0; i<len; i++){
            if(st.isEmpty() || isCoprime(st.peek(), nums[i])){
                st.push(nums[i]);
                continue;
            }else{

                while( !st.isEmpty() && !isCoprime(st.peek(), nums[i]) ){
                    nums[i] = (int)lcm( (long)st.pop(), (long)nums[i]);
                }
            }

            st.push(nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int a: st){
            list.add(a);
        }

        return list;
    }


    private boolean isCoprime(int a, int b){
        return gcd((long)a, (long)b)==1;
    }

    private long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }

    private long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
}