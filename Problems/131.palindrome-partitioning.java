// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();

        int len = s.length();

        helper(s, res,  new ArrayList<>());

        return res;
    }


    private void helper(String s, List<List<String>> res, List<String> curr){

        if(s.isEmpty()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int ed=1; ed<=s.length(); ed++){
            String prefix = s.substring(0, ed);
            if(ispal(prefix)){
                curr.add(prefix);
                helper(s.substring(ed), res, curr);
                curr.remove(curr.size()-1);
            }
        }

    }




    private boolean ispal (String s){
        int st=0, ed=s.length()-1;

        while(st<ed){
            if(s.charAt(st)!=s.charAt(ed))
                return false;
            st++;
            ed--;
        }

        return true;
    }
}