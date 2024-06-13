// https://leetcode.com/problems/reverse-linked-list-ii

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {
    struct ListNode *inihead = head;
    struct ListNode *pre = NULL;
    struct ListNode *next = NULL;
    for(int i=0;i<m;i++)
    {
        pre = head;
        head = head->next;
    }
       
    struct ListNode *ininode = head->next;
    struct ListNode *node = head;
    while(n!=0)
    {
        next = node->next;
        node->next = pre;
        pre = node;
        node = next;
        n--;
    }
    
    head -> next = node;
    ininode -> next = next;
    
    return inihead;
    
}