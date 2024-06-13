// https://leetcode.com/problems/balanced-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 /* Top Down 10.81 O(n^2)
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
//Bottom Up O(n)   //https://discuss.leetcode.com/topic/7798/the-bottom-up-o-n-solution-would-be-better/2

    
    
int dfsHeight (struct TreeNode* root) {
        if (root == NULL) return 0;
        
        int left = dfsHeight (root -> left);
        if (left == -1) return -1;
        int right = dfsHeight (root -> right);
        if (right == -1) return -1;
        
        if (abs(left - right) > 1)  return -1;
        return (left>right ? left :right ) + 1;
    }
    

bool isBalanced(struct TreeNode* root) {
        return dfsHeight (root) != -1;
    }






