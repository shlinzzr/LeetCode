// https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations

class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int score=0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums)
            list.add(num);
        
        int n = nums.length, m=multipliers.length;
        
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(0)
//         int max=Integer.MIN_VALUE;
//         int idx=0, cur=0;
//         while(st.size()>0){
//             for(int i=0; i<queue.size(); i++){
//                 int cur = cur + queue.pop()
                
                
                
//             }
//             int cur = st.pop();
            
//             if(list.size()>0){
//                 st.push(list.get(0));
//                 st.push(list.get(list.size()-1));
                
                
                
//             }
//         }
        
        
        
        for(int i=0; i<m; i++){
            
            boolean head = list.get(0) > list.get(list.size()-1)*multipliers[i]? true : false;
            int num= head ? list.get(0) : list.get(list.size()-1);
            System.out.println(num*multipliers[i]);
            score += num*multipliers[i];
            
            
            list.remove( head?0 : list.size()-1);
        }
        
        return score;
        
    }
}