// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            String org = getOrg(s);
            map.putIfAbsent(org, new ArrayList<>());
            map.get(org).add(s);
        }


        for(String key  : map.keySet()){
            res.add(new ArrayList<>(map.get(key)));
        }

        return res;
    }

    private String getOrg(String s){
        int[] arr = new int[26];

        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            
            for(int j=0; j<arr[i]; j++)
                sb.append((char) (i+'a'));
        }

        return sb.toString();
    }
}