// https://leetcode.com/problems/maximum-depth-of-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
 
 //need more practice....
int maxDepth(struct TreeNode* root) {
     if(root == NULL)
        return 0;
     else{
         int left = maxDepth(root->left);
         int right = maxDepth(root->right);
         
         return 1 + ((left > right) ? left : right);
     }
 
}