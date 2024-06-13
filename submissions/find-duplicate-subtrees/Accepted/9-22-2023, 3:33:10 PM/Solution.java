// https://leetcode.com/problems/find-duplicate-subtrees

class Solution {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        preOrder(root,map,res);
        return res;
    }
    private String preOrder(TreeNode root,Map<String,Integer> map,List<TreeNode> res){
        if(root==null){
            return "#";
        }
        String left = preOrder(root.left, map, res);
        String right = preOrder(root.right, map, res);
        String serial = left + "," + right + "," + root.val;
        if(map.containsKey(serial) && map.get(serial) == 1){
            res.add(root);
        }
        map.put(serial,map.getOrDefault(serial,0)+1);
        return serial;
    }
    
}