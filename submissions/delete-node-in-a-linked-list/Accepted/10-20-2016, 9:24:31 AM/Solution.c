// https://leetcode.com/problems/delete-node-in-a-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
    
    if ( node->next == NULL || node == NULL)  return;
    
 
    node->val = node->next->val;
    node->next = node->next->next;
        
        
        
   
   // 根本不用跑整個nodelist... 
   // int *ptr = *node;
   // while(ptr){
   // 
   //     if(ptr->next == node)
   //        ptr = ptr ->next ->next;
   //     else
   //        ptr = ptr -> next;
            
    
}