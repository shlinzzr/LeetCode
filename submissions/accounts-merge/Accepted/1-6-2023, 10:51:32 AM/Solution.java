// https://leetcode.com/problems/accounts-merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        // /**/
        // for(Map.Entry<String, String>en : parents.entrySet()){
        //     System.out.println(en.getKey()+ ", " + en.getValue());
        // }
        // System.out.println();
        //  for(Map.Entry<String, String>en : owner.entrySet()){
        //     System.out.println(en.getKey()+ ", " + en.getValue());
        // }
        
        
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        
        // /**/
        // System.out.println();
        // for(Map.Entry<String, String>en : parents.entrySet()){
        //     System.out.println(en.getKey()+ ", " + en.getValue());
        // }
        
        
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        
        // System.out.println();
        // for(Map.Entry<String, TreeSet<String>>en : unions.entrySet()){
        //     System.out.println(en.getKey()+ ", " + en.getValue().toString());
        // }
        
        
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }
    
// David4@m.co, David3@m.co
// David3@m.co, David2@m.co
// David0@m.co, David0@m.co
// David2@m.co, David0@m.co
// David1@m.co, David0@m.co
// David5@m.co, David3@m.co
    
    
    private String find(String s, Map<String, String> p) {
        
//         System.out.println("\ncall find( " + s   +"== p.get(s)=" + p.get(s) );
        
//         if(p.get(s) == s )
//             System.out.println("return s="+s);
        
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}