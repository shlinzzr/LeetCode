// https://leetcode.com/problems/binary-trees-with-factors

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);

        // [2,4,5,10]
        //  j      i

        HashMap<Integer,Long> map = new HashMap<Integer,Long>();
        long ans=0;


        for(int i=0;i<arr.length;i++){
            long sum=1; // 自己就是一個解
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j]))
                    sum +=  (map.get(arr[i]/arr[j])*map.get(arr[j])); // 左子樹* 右子樹
            }
            map.put(arr[i],sum); // 紀錄此節點的數量
            ans += sum;
        }
        return (int)(ans%1000000007);
    }
}