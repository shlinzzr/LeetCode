// https://leetcode.com/problems/fair-distribution-of-cookies

class Solution {

    int min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        List<Integer>[] arr = new ArrayList[k];
        for(int i=0; i<k; i++){
            arr[i] = new ArrayList<>();
        }

        Arrays.sort(cookies);
        int len = cookies.length;

        helper(cookies, len-1, arr);
        return min==Integer.MAX_VALUE? -1 : min;
    }

    private void helper(int[] cookies, int idx, List<Integer>[] arr ){
        int cnt=0;
        int maxSum = 0;
        for(List<Integer> list : arr){
            maxSum = Math.max(maxSum, getSum(list));

            if(idx<0){
                System.out.println("check oidx<0 " + cnt + " " + list);
                cnt++;
            }
        }

        if(idx<0){
            min = Math.min(min, maxSum);
            return;
        }

        if(maxSum>min) return;

        // 20 15 10 8 8
        int flag=0;

        for(int i=0; i<arr.length; i++){
            List<Integer> list = arr[i];
         
            int sum = getSum(list);
            if(sum+cookies[idx]>min) return;

            // if(sum==0) {
            //     if(flag==1) continue;
            //     else flag=1;
            // }

            list.add(cookies[idx]);

//    System.out.println(i+ " "+list+ " min="+min);

            helper(cookies, idx-1, arr);
            list.remove(list.size()-1);
        }


    }

    private int getSum(List<Integer> list){
        int sum = 0;
        for(int n : list){
            sum+=n;
        }
        return sum;
    }
}