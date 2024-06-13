// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
*/
struct ListNode* reverseList(struct ListNode* head) {
    if(NULL==head) return head;
    
    
    
    struct ListNode *p = head;
    struct ListNode *pre = NULL;

    
    
    while(node!=NULL){
        struct ListNode *ptmp = p -> next;
        p -> next = head;
        head = p;
        p = ptmp;
    }
    
    return head;
    
} 

