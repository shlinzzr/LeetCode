// https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int h = nums.size();
        
        PriorityQueue<Element> pq = new PriorityQueue<Element>(
            (e1, e2) -> Integer.compare(e1.val, e2.val)
        );

        int max=-10000;
        for(int i=0; i<h; i++){
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, e.val);
        }
        
        
        int st=-10000, ed=max, range = 20000;
        while(pq.size()==h){
            Element e = pq.poll();
            
            if(max-e.val<range){
                st=e.val;
                ed=max;
                range=ed-st;
            }
            
            
            if(e.idx+1<nums.get(e.row).size()){
                int newVal = nums.get(e.row).get(e.idx+1);
                max = Math.max(max, newVal);
                Element ele = new Element(e.row, e.idx+1, newVal);
                pq.offer(ele);
            }
        }
        
        
        return new int[]{st, ed};
    }
    
    
    
    class Element{
        int val;
        int row;
        int idx;
        public Element(int row, int idx, int val){
            this.row=row;
            this.idx=idx;
            this.val=val;
        }
    }
}