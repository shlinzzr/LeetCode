// https://leetcode.com/problems/maximum-depth-of-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int maxDepth(struct TreeNode* root) {
     
     if(root == NULL)
        return 0;
     else if(root -> left)
        return 1 + maxDepth(root->left);
     else if(root -> right)
         return 1 + maxDepth(root->right);
     else 
         return 1; 
}