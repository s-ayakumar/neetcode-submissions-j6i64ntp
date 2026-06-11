/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if (list1 == nullptr) return list2;
        if (list2 == nullptr) return list1;

        ListNode* l1 = list1;
        ListNode* l2 = list2;
        ListNode* dummy = new ListNode(0); 
        ListNode* curr = dummy;

        while (l1 != nullptr && l2 != nullptr)
        {
            if (l1->val <= l2->val)
            {
                curr->next = l1;
                curr = curr->next;
                l1 = l1->next;
            }
            else
            {
                curr->next = l2;
                curr = curr->next;
                l2 = l2->next;
            }
        }

        while (l1 != nullptr)
        {
            curr->next = l1;
            l1 = l1->next;
            curr = curr->next;
        }       
        while (l2 != nullptr)
        {
            curr->next = l2;
            l2 = l2->next;
            curr = curr->next;
        }

        return dummy->next;

    }
};
