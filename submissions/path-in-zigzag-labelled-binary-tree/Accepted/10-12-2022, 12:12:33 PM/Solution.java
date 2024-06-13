// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        
        int level=0, total=0;
        while(total<label){
            total+=Math.pow(2, level);
            level++;
        }
        level--;
        
         while (level >= 0) {
            res.add(0, label);
            int min = (int)Math.pow(2, level);
            int max = (int)Math.pow(2, level+1)-1;
            int reversedLabel = min + max - label;
            label = reversedLabel/2;
            level = level - 1;
        }
        
        
        
        
        
        return res;
    }
    
    
}