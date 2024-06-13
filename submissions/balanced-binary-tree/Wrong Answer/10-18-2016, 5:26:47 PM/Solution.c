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
    bool sus = false;
    
    if(root == NULL)
       return 0;
    else{
       
      int leftval = isBalanced(root->left);
      int rightval= isBalanced(root->right);
      
      if(abs(leftval - rightval)>1)
        sus = false;
      else 
        sus = true;
        
        
      return (1 + (leftval>rightval)? leftval:rightval);
    }
    
    
}