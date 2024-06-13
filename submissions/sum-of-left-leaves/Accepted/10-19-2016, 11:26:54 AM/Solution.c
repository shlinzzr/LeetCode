// https://leetcode.com/problems/sum-of-left-leaves

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
 
// all by myself cost 1hr.....   56.33%
int sumOfLeftLeaves(struct TreeNode* root) {
    
    if(root == NULL) return 0;
    
    int sum = 0;
    if (root->left != NULL)
        if(root->left->left == NULL && root->left->right == NULL)
            sum =  root->left->val;

    return sum + sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->right);
}