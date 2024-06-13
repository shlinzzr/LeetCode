// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };


//iterative
struct ListNode* reverseList(struct ListNode* head) {
  
    struct ListNode *pre = NULL;
    struct ListNode *node = head;

    while(node!=NULL){
        struct ListNode *next = node -> next;
        node -> next = pre;
        pre = node;
        node = next;
    }
    
    return pre;
    
} 
*/

struct ListNode* reverseList(struct ListNode* head) {
    if(head==NULL || head->next==NULL ) return NULL;
    
    
    struct ListNode *next = head -> next;
    head -> next = NULL;
    
    struct ListNode *newhead =  reverseList(next);
    
    next -> next = node;
    
    return newhead;
  
     
    
} 

