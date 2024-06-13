// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal

class Solution {
    List<Integer> flipped = new ArrayList<>();
    int index =0;;
    int[] voyage;
    boolean isValid =true;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;

        dfs(root);

        if(!isValid) return Arrays.asList(-1);

        return flipped;
    }

    public void dfs(TreeNode node) {

        if(node==null || isValid==false)  return;

        if (node.val != voyage[index++]) {
            isValid = false;
            return;
        }

        if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
            //filp
            flipped.add(node.val);
            dfs(node.right);
            dfs(node.left);
        } else { // original
            dfs(node.left);
            dfs(node.right);
        }
    }
}