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
    void reorderList(ListNode* head) {
        int length;

        ListNode* slow = head;
        ListNode* fast = head;

        while (fast != nullptr && fast->next != nullptr)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* second_half = slow->next;
        slow->next = nullptr;
        ListNode* reverse_second = ReverseList(second_half);
        ListNode* temp = head->next;
        ListNode* curr = temp;
        ListNode* L1 = head;
        ListNode* L2 = reverse_second;

        while (L2 != nullptr)
        {
            ListNode* L1_next = L1->next;
            ListNode* L2_next = L2->next;

            L1->next = L2;

            if (L1_next == nullptr) break;

            L2->next = L1_next;

            L1 = L1_next;
            L2 = L2_next;
        }


    }

private:
    ListNode* ReverseList (ListNode* head)
    {
        ListNode* curr = head;
        ListNode* prev = nullptr;

        while (curr != nullptr)
        {
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
};
