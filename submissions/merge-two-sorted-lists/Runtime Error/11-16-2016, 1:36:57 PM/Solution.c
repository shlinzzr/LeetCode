// https://leetcode.com/problems/merge-two-sorted-lists

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* head;
    
    if(l1->val <= l2->val) 
        head = l1;
    else 
        head = l2;
    
    while(l1 && l2)
    {
        if(l1->val <= l2->val)
        {
            l1 = l1->next;
        }
        else{
            struct ListNode* tmp;
            tmp=l1->next;
            l1->next = l2;
            l2=l2->next;
            l1=tmp;
        }
        
    }
    return head;
}