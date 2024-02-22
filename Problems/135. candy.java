// https://leetcode.com/problems/candy

class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] arr = new int[len];
        Arrays.fill(arr,1);

        for(int i=0; i<len-1; i++){
            if(ratings[i+1]>ratings[i]){
                arr[i+1] = Math.max(arr[i+1], arr[i]+1);
            }
        }

        for(int i=len-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                arr[i] = Math.max(arr[i], arr[i+1]+1);
            }
        }

        int sum = 0;
        for(int a : arr){
            sum+=a;

        }
        return sum;

    }
}