// https://leetcode.com/problems/path-sum-iii

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
int pathSum(struct TreeNode* root, int sum) {
    int path=0;
    
    struct TreeNode* p = root;
    
    while(p->left || p->right)
    {
        if(p->left)
        {
            if(p->val + pathSum(p->left, sum-p->val)==sum) path++;
            path += pathSum(p->left, sum);
            
        }
        if(p->right){
            if(p->val + pathSum(p->right, sum-p->val)==sum) path++;
            path += pathSum(p->right, sum);
        }
        
         if(p->left) p=p->left;
         if(p->right) p=p->right;
    }
    return path;
        
    
    /*
    if(root->val + root->left->val == sum )
        return 1;
    else path += pathSum(root->left, sum);
    
    if(root->val + root->right->val == sum)
        return 1;
    else path += pathSum(root->right, sum);
    
    return path;*/
}