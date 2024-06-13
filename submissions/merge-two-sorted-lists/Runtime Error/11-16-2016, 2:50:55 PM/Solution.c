// https://leetcode.com/problems/merge-two-sorted-lists

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };

 
 //recursive
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {

    if(l1 == NULL)   return l2;
    if(l2 == NULL)   return l1;
    
    if(l1->val <= l2->val)
    {
        l1->next = mergeTwoLists(l1->next, l2);
        return l1;
     }
     else
     {
        l2->next = mergeTwoLists(l2->next, l1);
        return l2;
     }
}
 */

//iterative
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* head;
    if(l1 == NULL)   return l2;
    if(l2 == NULL)   return l1;
    
    head = (l1->val <= l2->val)? l1 : l2;
    
    struct ListNode* p;
    
    while(l1 && l2){
        if(l1->val < l2->val)   { p->next = l1; l1 = l1->next; }
        else                    { p->next = l2; l2 = l2->next; }
        p=p->next;
    }
    
    if(l1)  p->next=l1;
    else    p->next=l2;
    
    
    
    return head;
}