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
    struct ListNode *node = head;
    struct ListNode *next = node->next;
    
    for(int i=0;i<m-1;i++)
    {
        pre = node;
        node = node->next;
        next = node->next;
    }
    struct ListNode *ininode = node;
    
    while(n-m>0)
    {
        next = node->next;
        node->next = pre;
        pre = node;
        node = next;
        n--;
    }
    //node->next = pre;
    head = node;
    
    
    return head;
    
}