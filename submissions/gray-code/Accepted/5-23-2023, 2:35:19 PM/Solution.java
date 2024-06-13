// https://leetcode.com/problems/gray-code

class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> res = new LinkedList<>();
        res.add(0);
        
        for (int i=0; i<n; i++)
        {
            int len = res.size();
            for (int j=len-1; j>=0; j--)
            {
                res.add(res.get(j) | (1<<i));
            }
        }
        return res;
        
    }
}