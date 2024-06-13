// https://leetcode.com/problems/same-tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 
bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
   
    if (p==NULL || q==NULL) return true;
    
    else if(p->val==q->val && p->left==q->left && p->right==q->right)
        return true;

    
    return (isSameTree(p->left,q->left) && isSameTree(p->left,q->left));
}
*/

bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
   
    if (p==NULL && q==NULL) return true;
    
    else if(p==NULL || q==NULL) return false;
    
    else if(p->val!=q->val)  return false;
    
    return (isSameTree(p->left,q->left) && isSameTree(p->right,q->right));
}

// Q1:沒有另外的space 紀錄success or fail 該如何節省space來呈現
//ans 可先宣告一個result來記錄 然後在return時直接取代變數

//note:  1.return Recursive 寫在最底下  return (左節點&&右節點)
//       2.想true的中止條件
//       3.想false的中止條件