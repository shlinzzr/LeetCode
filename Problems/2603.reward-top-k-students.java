// https://leetcode.com/problems/reward-top-k-students

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        
        for(String p : positive_feedback){
            pos.add(p);
        }
        // pos.add("no");
        
        for(String p : negative_feedback){
            neg.add(p);
        }
        // neg.add("no");
        
        List<Integer> res = new ArrayList<>();
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[1], b[1])!=0 ? Long.compare(a[1], b[1]) : Long.compare(b[0], a[0])
        );
        
        
        int len = report.length;
        for(int i=0; i<len; i++){
            
            String r = report[i];
            long cnt =0;
            String[] arr = r.split(" ");
            for(String a : arr){
                if(pos.contains(a)){
                    cnt+=3;
                }
                
                if(neg.contains(a)){
                    cnt-=1;
                }
            }
            
            pq.offer(new long[]{student_id[i], cnt});
            
            if(pq.size()>k){
                pq.poll();
            }
            
            
        }
        
        while(pq.size()>0){
            res.add(0, (int)pq.poll()[0]);
        }
        
        
        
        return res;
        
    }
}