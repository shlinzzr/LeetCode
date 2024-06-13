// https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        int sum = sumDigit(n);
        if (sum<=target)
            return 0;
        List<Integer> list = getList(n);
        
        int res=0;
        int carry =1;
        for(int i : list){
            
            sum-=i;
            int comp = carry==1 ? (10-i) : (10-i-1);
            
            res+=(comp)*carry;
            carry*=10;
            // System.out.println(res);
            if(sum<=target)
                break;
        }

        return res;
        
    }
    
    
    private List<Integer> getList(long n){
        List<Integer> list = new ArrayList<>();
        
        
        // 123 => [3, 2, 1]
        while(n>0){
            list.add((int)n%10);
            n/=10;
        }
        return list;
    }
    
    
    private int sumDigit(long n){
        
        int res = 0;
        
        while(n>0){
            res += (int)n%10;
            n/=10;
        }
        
        return res;
        
        
    }
}