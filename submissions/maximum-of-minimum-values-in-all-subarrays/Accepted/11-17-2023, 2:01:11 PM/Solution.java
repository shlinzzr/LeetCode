// https://leetcode.com/problems/maximum-of-minimum-values-in-all-subarrays

class Solution {
    public int[] findMaximums(int[] nums) {
        int len = nums.length;
        PriorityQueue<int[]> pq= new PriorityQueue<>( // val , idx
            (a,b) -> b[0]-a[0] // sort by val desc
        );

        for (int i=0; i<len; i++)
            pq.offer(new int[]{nums[i],i});
        
        int[] nextSmaller = new int[len];             
        Arrays.fill(nextSmaller, len);
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<len; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        st.clear();
        int[] prevSmaller = new int[len];   
        Arrays.fill(prevSmaller, -1);
        for (int i=len-1; i>=0; i--){
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]){
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }


        List<Integer> list = new ArrayList<>();
        for (int w=1; w<=len; w++)
        {                
            while (true) {
                // if (pq.isEmpty()) 
                //     break;
                int p = pq.peek()[1];
                if (nextSmaller[p] - prevSmaller[p] -1 >= w)
                    break;
                pq.poll();
            }
            list.add(pq.peek()[0]);
        }

        int[] res = new int[len];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        
        return res;

    }
}