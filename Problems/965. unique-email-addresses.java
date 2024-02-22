// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>(); 
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            String[] parts = email.split("@"); 
            String[] local = parts[0].split("\\+");

            set.add(sb.append(local[0].replace(".", "")).append("@").append(parts[1]).toString());
        }
        return set.size();
    }
}