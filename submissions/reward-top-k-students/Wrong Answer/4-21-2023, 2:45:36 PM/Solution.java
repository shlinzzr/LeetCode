// https://leetcode.com/problems/reward-top-k-students

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        
        for(String p : positive_feedback){
            pos.add(p);
        }
        pos.add("no");
        
        for(String p : negative_feedback){
            neg.add(p);
        }
        neg.add("no");
        
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[1]!=b[1] ? a[1]-b[1] : b[0]-a[0]
        );
        
        
        int len = report.length;
        for(int i=0; i<len; i++){
            
            String r = report[i];
            int cnt =0;
            String[] arr = r.split(" ");
            for(String a : arr){
                if(pos.contains(a)){
                    cnt+=3;
                }
                
                if(neg.contains(a)){
                    cnt-=1;
                }
            }
            
            pq.offer(new int[]{student_id[i], cnt});
            
            if(pq.size()>k){
                pq.poll();
            }
            
            
        }
        
        for(int[] p : pq){
            res.add(0, p[0]);
        }
        
        
        
        return res;
        
    }
}