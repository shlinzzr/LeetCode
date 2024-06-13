// https://leetcode.com/problems/furthest-building-you-can-reach

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;

        // dp ? 

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int i=0;
        for(;i<len-1 && bricks>0; i++){

            if(heights[i+1]<heights[i])
                continue;

            if(bricks<heights[i+1]-heights[i]){
                if(ladders==0)
                    break;
                else{
                    
                }
            }
                

            bricks -= heights[i+1]-heights[i];
            pq.offer(heights[i+1]-heights[i]);
        }

        while(!pq.isEmpty() && ladders>0 && i+1<len){

            bricks+=pq.poll();
            ladders-=1;
            while(i+1<len && bricks>=heights[i+1]-heights[i]){
                bricks -= heights[i+1]-heights[i];
                i++;
            }
        }

        return i;

    }
}