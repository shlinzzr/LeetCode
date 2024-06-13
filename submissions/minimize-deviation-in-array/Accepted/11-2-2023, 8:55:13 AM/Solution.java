// https://leetcode.com/problems/minimize-deviation-in-array

class Solution {
    public int minimumDeviation(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        
        TreeSet<Integer> set = new TreeSet<>();

        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n % 2 == 0) {
                set.add(n);
            } else {
                set.add(2*n);
            }
        }

        // 2, 14 min=12
        // 2, 7 min=5
        
        // System.out.println(pq+ " min=" + min);     

        while(true){

            min = Math.min(min, set.last()-set.first());

            int last = set.last();
            set.remove(last);

            if(last%2==0)
                set.add(last/2);
            else 
                break;
        }

        return min;

    }
}