// https://leetcode.com/problems/brace-expansion-ii

class Solution {
    public List<String> braceExpansionII(String ex) {
        int n = ex.length();
        
        // new test case: "{a,b},x{c,{d,e}y}"
        Set<String> res = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        dq.offer(ex);
        
        while (!dq.isEmpty()) {
            String cur = dq.poll();
            if (cur.indexOf("{") == -1) {
                res.add(cur);
                continue;
            }
            
            int left = cur.indexOf("{");
            int index = left;
            while (index < cur.length() && cur.charAt(index) != '}') {
                if (cur.charAt(index) == '{') {
                    left = index;
                }
                index++;
            }
            int right = index;
            
            // left = '{' , right = '}'
            // a, b
            String prefix = cur.substring(0, left);
            String[] processing = cur.substring(left + 1, right).split(",");
            String suffix = cur.substring(right + 1);
            
            for (String part : processing) {
                StringBuilder sb = new StringBuilder(prefix);
                sb.append(part).append(suffix);
                dq.offer(sb.toString());
            }
        }
        
        List<String> resList = new ArrayList<>(res);
        Collections.sort(resList);
        return resList;
    }
}