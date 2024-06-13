// https://leetcode.com/problems/binary-searchable-numbers-in-an-unsorted-array

class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int len = nums.length;

        Stack<Integer> st = new Stack<>();

        int[] prevGreater = new int[len];
        Arrays.fill(prevGreater, -1);
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                prevGreater[st.pop()] = i;
            }
            st.push(i);
        }

        int[] nextSmaller = new int[len];
        Arrays.fill(nextSmaller, len);
        for(int i=0; i<len; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }

        int res = 0;
        for(int i=0; i<len; i++){
            if(nextSmaller[i]==len && prevGreater[i]==-1){
                res++;
            }
        }
        return res;
        
    }
}


/*


x x x x x x t x x x 
      ^
- - - - x x t x x x


当pivot < target时，会将pivot左侧的数都抹去。此时如果抹去的数字里有比pivot大的数字，那么它将永远不会被找到。有人会问，被抹去的数字里那些比pivot小的不同样永远无法搜到了吗？但是没有关系，因为我们的target大于pivot，说明我们不关心那些比pivot小的数字（他们不是我们的搜索目标）。因此，我们得出结论，对于任意一个数nums[i]，如果它的prevGreater存在，那么当nums[i]被选为pivot时，那个prevGreater就会无法被该算法搜到。

同理，当pivot > target时，会将pivot右侧的数都抹去。此时如果抹去的数字里有比pivot小的数字，那么它将永远不会被找到。同样，我们不关心那些比pviot大的数字是否被抹掉（因为它们不是我们的搜索目标）。因此我们有类似的结论，对于任意一个数nums[i]，如果它的nextSmaller存在，那么当nums[i]被选为pivot时，那个nextSmaller就会无法被该算法搜到。

我们提前用两轮单调栈，用o(N)的时间把每个元素的prevGreater和nextSmaller都找到。只有同时不存在prevGreater和nextSmaller的那些数，才能保证被算法搜索到。

*/