// https://leetcode.com/problems/balanced-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 /* 10.81 O(n^2)
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
*/
// Bottom Up O(n)
bool isBalanced(struct TreeNode* root) {
        return dfsHeight (root) != -1;
    }
    
    
int dfsHeight (TreeNode* root) {
        if (root == NULL) return 0;
        
        int left = dfsHeight (root -> left);
        if (left == -1) return -1;
        int right = dfsHeight (root -> right);
        if (right == -1) return -1;
        
        if (abs(left - rightH) > 1)  return -1;
        return max (left, right) + 1;
    }
    
};








