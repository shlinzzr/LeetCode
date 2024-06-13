// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };


//iterative
struct ListNode* reverseList(struct ListNode* head) {
  
    struct ListNode *prev = NULL;

    while(head!=NULL){
        struct ListNode *tmp = head -> next;
        head -> next = prev;
        prev = head;
        head = tmp;
    }
    
    return prev;
    
} 
*/
// recursive
struct ListNode* reverseList(struct ListNode* head) {
    if(head==NULL || head->next==NULL ) return head;
    
    
    struct ListNode *next = head -> next;
    head -> next = NULL;
    
    struct ListNode *newhead =  reverseList(next);
    
    next -> next = head;
    
    return newhead;
  
     
    
} 

