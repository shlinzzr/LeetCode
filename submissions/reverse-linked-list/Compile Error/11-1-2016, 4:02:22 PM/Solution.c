// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    
    struct ListNode* ptr = null;
    struct ListNode* node = head;

    while(next){
        struct ListNode *next = node -> next;
        node -> next = ptr;
        ptr = node;
        node = next;
    }
    
    
}