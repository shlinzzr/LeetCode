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
    
    int sum;
    if (root->left != NULL)
        if(root->left->left == NULL && root->left->right == NULL)
            sum =  root->left->val;
    

    sum += sumOfLeftLeaves(root->left);
    sum += sumOfLeftLeaves(root->right);
    
    printf("%d",sum);
    
    return sum;


    
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