// https://leetcode.com/problems/balanced-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
bool isBalanced(struct TreeNode* root) {
    bool sus = true;
    
    if(root == NULL)
       return true;
    else{
       
      int leftval = isBalanced(root->left);
      int rightval= isBalanced(root->right);
      printf("%d %d", leftval, rightval);
      if(abs(leftval - rightval)>1)
        sus = false;
     
        
        
      return (1 + (leftval>rightval)? leftval:rightval);
    }
    
    
}