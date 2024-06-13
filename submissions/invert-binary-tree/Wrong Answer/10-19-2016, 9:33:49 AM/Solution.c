// https://leetcode.com/problems/invert-binary-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* invertTree(struct TreeNode* root) {
    
    if (root==NULL) return;
    
    struct TreeNode *left = root->left;
    struct TreeNode *right = root->right;
   
    root->left = right;
    root->right = left;
    
    invertTree(root->left);
    invertTree(root->right);
    
    return;
    
}