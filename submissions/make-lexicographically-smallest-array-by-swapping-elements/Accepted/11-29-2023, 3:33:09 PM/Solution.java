// https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int len = nums.length;


        int[] res =new int[len];
        int[][] arr =new int[len][2]; // val, idx

        for(int i=0;i<len;i++)
            arr[i]=new int[]{nums[i], i};

        Arrays.sort(arr, (a,b) -> a[0]-b[0]); // sort by val asc

        List<Integer> list = new ArrayList<>(); //idx

        for(int i=0;i<len;i++) {
            list.add(arr[i][1]); // idx

            if(i==len-1 || arr[i][0]+limit < arr[i+1][0]) { // nums[i]+limit < nums[i+1]
                Collections.sort(list);

                int prev = i-list.size()+1;

                for(int j=prev;j<=i;j++) 
                    res[list.get(j-prev)] = arr[j][0];

                list=new ArrayList<>();
            }
        }
        return res;
    }
}