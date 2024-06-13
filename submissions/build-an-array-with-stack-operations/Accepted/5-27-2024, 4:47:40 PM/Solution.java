// https://leetcode.com/problems/build-an-array-with-stack-operations

class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> res = new ArrayList<>();

        int val=1;
        for(int i=0; i<target.length; i++){
            int t=target[i];

            while(val<t){
                res.add("Push");
                res.add("Pop");
                val++;
            }

             if(val==t){
                res.add("Push");
                val++;
            }
        }

        return res;
    }
}