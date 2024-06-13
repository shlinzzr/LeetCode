// https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful

class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        
        int sum = sumDigit(n);
        if (sum<=target)
            return 0;
        List<Integer> list = getList(n);
        
        
        System.out.println(sum);
        
        int res=0;
        int carry =1;
        for(int i : list){
            
            if(sum<target)
                break;
            
            sum-=i;
            int comp = carry==1 ? (10-i) : (10-i-1);
            
            res+=(comp)*carry;
            carry*=10;
            // System.out.println("i="+i  + "sum="+sum + " comp="+comp + " res="+res);
            
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
    
    
    // 19    1
    
    // sum =10
    // res = 1+ 10-1-1 *10, sum=9
    
    
}