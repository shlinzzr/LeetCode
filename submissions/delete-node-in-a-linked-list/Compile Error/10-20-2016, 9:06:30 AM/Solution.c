// https://leetcode.com/problems/delete-node-in-a-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
     
    int *ptr = node;
    while(ptr){
    
        if(ptr->next == node)
           ptr = ptr ->next ->next;
        else
           ptr = ptr -> next;
            
    }
}