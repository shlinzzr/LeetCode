// https://leetcode.com/problems/remove-duplicates-from-sorted-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if(head==NULL) return NULL;
    
    struct ListNode *left  = head;
    struct ListNode *right = head;
    
    while(right->next)
    {
        right = right->next;

        if( left->val == right->val)
            left->next = NULL;
        else{
            left->next = right;
            left = left->next;
        }
        
    }
    return head;
}