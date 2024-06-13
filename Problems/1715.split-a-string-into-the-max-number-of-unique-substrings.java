// https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings

class Solution {
    int max = 0;
    HashSet<String> set = new HashSet<>();
    public int maxUniqueSplit(String s) {

        helper(s, 0);

        return max;
    }

    private void helper(String s, int st){
        // System.out.println(st + " set="+set);
        if(st==s.length()){
            max = Math.max(max, set.size());
            return ;
        }

        for(int i=st+1; i<=s.length(); i++){
            String sub = s.substring(st, i);
            if(!set.contains(sub)){
                set.add(sub);
                helper(s, i);
                set.remove(sub);
            }
        }
    }
}