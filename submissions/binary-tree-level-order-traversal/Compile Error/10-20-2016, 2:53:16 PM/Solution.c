// https://leetcode.com/problems/binary-tree-level-order-traversal

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *columnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
 
 //BFS tree 太複雜 直接看CODE  QQ  //https://discuss.leetcode.com/topic/63844/c-3ms-easy-undestanding-one-queue
int** levelOrder(struct TreeNode* root, int** columnSizes, int* returnSize) {
    
    int *arr = malloc((returnSize+1)*sizeof(int));
    
    for(int i=0;i<returnSize; i++)
    {
         for(int j=0;j<i+1;j++)
         {
             arr[i] = root[j];
             i++;
             
         }
    }
}