// https://leetcode.com/problems/sum-of-left-leaves

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int sumOfLeftLeaves(struct TreeNode* root) {
    int sum;
    int val = root->val;
    sum +=val;
    
    sum += sumOfLeftLeaves(root->left);
    sum = sumOfLeftLeaves(root->right);
    
    return val;
}