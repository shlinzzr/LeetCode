// https://leetcode.com/problems/binary-trees-with-factors

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        HashMap<Integer,Long> map = new HashMap<Integer,Long>();
        long ans=0;

        // [2,4,5,10]
        //  j      i


        for(int i=0;i<arr.length;i++){
            long sum=1;
            for(int j=0;j<i;j++){

                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j]))
                    sum +=  (map.get(arr[i]/arr[j])*map.get(arr[j]));
            }
            map.put(arr[i],sum);
            ans=ans+sum;
        }
        return (int)(ans%1000000007);
    }
}