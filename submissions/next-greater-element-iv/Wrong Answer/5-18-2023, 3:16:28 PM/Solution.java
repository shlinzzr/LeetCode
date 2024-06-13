// https://leetcode.com/problems/next-greater-element-iv

class Solution {
    public int[] secondGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        Queue<Integer> st2 = new LinkedList<>();
        
        int len = nums.length;
        boolean[] bool = new boolean[len];
        
         int[] res = new int[len];
        Arrays.fill(res, -1);
        
        // st = 2 4 0 9
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            
            while(!st2.isEmpty() && nums[st2.peek()]<n){
                res[st2.poll()]= nums[i];
            }
            
            while(!st.isEmpty() && nums[st.peek()]<n){
                
                st2.offer(st.pop());
            }
            st.push(i);
            
//             System.out.println("i="+i +" n=" + nums[i]);
//             for(int s: st2){
//                 System.out.print(nums[s] + ", ");
//             }
//             System.out.println("");
            
//             for(int s: st){
//                 System.out.print(nums[s] + ", ");
//             }
//             System.out.println("\n");
        }
        
       
        return res;
        
        
    }
}