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
    
    if(root == NULL)
       return true;
    else{
      int left = maxDepth(root->left);
      int right= maxDepth(root->right);
      //printf("%d %d", leftval, rightval);
      if(abs(left - right)>1)
          return false;
      else 
          return isBalanced(root->left)  && isBalanced(root->right);
   
    }
}

int maxDepth(struct TreeNode* root) {
     if(root == NULL)
        return 0;
     else{
         int left = maxDepth(root->left);
         int right = maxDepth(root->right);
         
         return 1 + ((left > right) ? left : right);
     }
 
}









