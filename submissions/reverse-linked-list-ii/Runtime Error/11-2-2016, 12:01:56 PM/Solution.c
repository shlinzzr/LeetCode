// https://leetcode.com/problems/reverse-linked-list-ii

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseBetween(struct ListNode* head, int m, int n) {
    struct ListNode *pre = NULL;
    struct ListNode *next = NULL;
    for(int i=0;i<m-1;i++)
    {
        pre = head;
        head = head->next;
        printf("%d",head->val);
    }
    struct ListNode *ininode = head;
    struct ListNode *node = head;
    struct ListNode *inihead = pre;
    
    while(n-m>=0)
    {
        next = node->next;
        node->next = pre;
        pre = node;
        node = next;
        n--;
    }
    
       inihead -> next = pre;
       ininode -> next = node;
    
    return inihead;
    
}