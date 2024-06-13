// https://leetcode.com/problems/reverse-linked-list

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };

struct ListNode* reverseList(struct ListNode* head) {
    
    struct ListNode *pre = NULL;
    struct ListNode *node = head;

    while(node){
        struct ListNode *next = node -> next;
        node -> next = pre;
        pre = node;
        node = next;
    }
    
    return node;
    
} */
struct ListNode* reverseList(struct ListNode* head) {
	if(NULL==head) return head;

	struct ListNode *p=head;
	p=head->next;
	head->next=NULL;
	while(NULL!=p){
		struct ListNode *ptmp=p->next;
		p->next=head;
		head=p;
		p=ptmp;
	}
	return head;
}