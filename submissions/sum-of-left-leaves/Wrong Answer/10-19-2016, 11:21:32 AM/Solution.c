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
    
    if(root == NULL) return 0;
    
    int sum = 0;
    if (root->left != NULL)
        if(root->left->left == NULL && root->left->right == NULL)
            sum =  root->left->val;
    

    
    return sum + sumOfLeftLeaves(root->left) + sumOfLeftLeaves(root->left);


    
   // int sum;
   // int val = root->val;
   // 
   // if(root->left!=NULL)
   //     sum += sumOfLeftLeaves(root->left);
   // else if(root->right!=NULL)
   //     sum = sumOfLeftLeaves(root->right);
   //
   // return sum + val;
}