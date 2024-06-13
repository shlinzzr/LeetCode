// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target

class Solution {
    
    int min = Integer.MAX_VALUE;
    int ans = -1;
    
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        
        int st=0, ed=100000;
        while(st<ed){
            int mid = st + (ed-st+1)/2;
            
            if(isOk(arr, mid, target)){
                st = mid;
            }else{
                ed= mid-1;
            }
        }
        
        return ans;
    }
    
    private boolean isOk(int[] arr , int mid, int target){
        
        int len = arr.length;
        
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        for(int a : arr){
            if(a>mid){
                list.add(mid);
                sum+=mid;
            }else{
                list.add(a);
                sum+=a;            
            }
        }
        
        if(Math.abs(sum-target) <min){
            min = Math.abs(sum-target);
            ans = mid;
        }
        
        // System.out.println(mid + " sum=" + sum + " list:" + list.toString());
        return sum<target;
    }
}