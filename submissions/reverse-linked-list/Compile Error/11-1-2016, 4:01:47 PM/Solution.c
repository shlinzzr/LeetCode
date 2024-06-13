// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    
    struct *ptr = null;
    struct *node = head;

    while(next){
        struct *next = node -> next;
        node -> next = ptr;
        ptr = node;
        node = next;
    }
    
    
    
}