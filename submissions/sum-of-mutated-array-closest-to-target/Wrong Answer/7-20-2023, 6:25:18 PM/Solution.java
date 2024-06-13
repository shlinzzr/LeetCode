// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target

class Solution {
    
    int min = Integer.MAX_VALUE;
    int ans = -1;
    
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        
        int st=0, ed=100000;
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            if(getSum(arr, mid)>=target){
                ed = mid;
            }else{
                st= mid+1;
            }
        }
        
        int sum1 = getSum(arr, st);
        int sum2= getSum(arr, st-1);
        
        return Math.abs(sum1-target) < Math.abs(sum2-target) ? st : st-1;
        
    }
    
    private int getSum(int[] arr , int mid){
        
        int len = arr.length;
        
        // List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for(int a : arr){
            if(a>mid){
                // list.add(mid);
                sum+=mid;
            }else{
                // list.add(a);
                sum+=a;            
            }
        }
        
        // System.out.println(mid + " sum=" + sum + " list:" + list.toString() + " "  + (sum<target));
        // return sum>target;
        
        return sum;
    }
}