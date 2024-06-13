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

 
 //BFS tree 太複雜 直接看CODE  QQ  //https://discuss.leetcode.com/topic/63844/c-3ms-easy-undestanding-one-queue
int** levelOrder(struct TreeNode* root, int** columnSizes, int* returnSize) {
    
    int *arr = malloc((*returnSize+1)*sizeof(int));
    
    for(int i=0;i<returnSize; i++)
    {
         for(int j=0;j<i+1;j++)
         {
             //arr[i] = root[j];
             i++;
             
         }
    }
    return arr;
}
 */
typedef struct TreeNode TreeNode;
int** levelOrder(struct TreeNode* root, int** columnSizes, int* returnSize) {
    if (root == NULL) return NULL;
    
    int **ans = malloc(sizeof(int *) * 1000); //2-dim array ?
    *columnSizes = malloc(sizeof(int) * 1000);
    
    TreeNode *queue[2000]; //easy queue
    int first = 0, end = 0;
    queue[end++] = root;
    
    int nodes_cur_level = 1, nodes_next_level = 0, level = 0;
    
    while (first < end) {
        ans[level] = malloc( 1000 * sizeof(int) );
        for (int i = 0; i < nodes_cur_level && first < end; i++) {
            printf("first=%d end=%d cur=%d \r\n",first , end, nodes_cur_level);
            TreeNode *tmp = queue[first++];
            
            ans[level][i] = tmp->val;
            printf("tmp=%d \r\n", tmp->val);
            
            if (tmp->left) {
                queue[end++] = tmp->left;
                nodes_next_level++;
            }
            if (tmp->right) {
                queue[end++] = tmp->right;
                nodes_next_level++;
            }
        }
        
        (*columnSizes)[level++] = nodes_cur_level;
        if ((nodes_cur_level = nodes_next_level) == 0) break;
        
        nodes_next_level = 0;
    }
    
    *returnSize = level;
    return ans;
}