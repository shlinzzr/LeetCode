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
    struct ListNode *right = head->next;
    
    while(left)
    {
        int leftval  = left->val;
        int rightval = right->val;
        
        if(leftval == rightval)
            right = right -> next;
        else
            left->next = right;
        
    }
    return head;
}