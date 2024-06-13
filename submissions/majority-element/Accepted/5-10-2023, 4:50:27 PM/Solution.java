// https://leetcode.com/problems/majority-element

class Solution {
    
    //sol 1 : brute force : Time(n^2) Space(1)
    //sol 2 : HashMap : Time(n)     Space(n)
    //sol 3 : sorting : Time(nlgn), Space(1)
    //sol 4 : bit     : Time(nlogC) Space(1)
    //sol 5 : randomization ???
    //sol 6 : divide & conquer ??? 
    
    //sol 7 : Boyer-Moore Time(n), Space(1)
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
            
            System.out.println(count);
        }

        return candidate;
    }
}