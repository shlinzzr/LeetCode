// https://leetcode.com/problems/find-unique-binary-string

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();
        Set<String> set = new HashSet<>();
        set.add("");


        for(int i=0; i<len; i++){

            Set<String> tmp = new HashSet<>();
            for(String s : set){
                tmp.add(s+"0");
                tmp.add(s+"1");
            }

            set=tmp;
        }

        for(String n : nums){
            set.remove(n);
        }

        return new ArrayList<>(set).get(0);

    }


}