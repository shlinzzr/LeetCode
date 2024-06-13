// https://leetcode.com/problems/unique-email-addresses

class Solution {
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> set = new HashSet<>();
        
        for(String mail: emails){
            
            String[] arr = mail.split("@");
            
            arr[0] = arr[0].replaceAll("\\.", "");
            
            int plus = arr[0].indexOf("+");
            
            if(plus!=-1)
                arr[0] = arr[0].substring(0, plus);
            
            // System.out.println(arr[0]);
            
            set.add(arr[0]+arr[1]);
            
            
        }
        
        return set.size();
        
    }
}