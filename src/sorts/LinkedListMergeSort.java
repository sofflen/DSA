package sorts;

import utility.ListNode;

/**
Approach
To merge two sorted linked lists, we recursively compare the values of the current nodes of each list and link them accordingly. We continue this process until we reach the end of either list.

Complexity
Time complexity: O(n+m)O(n + m)O(n+m), where nnn and mmm are the lengths of the two lists.
Space complexity: O(n+m)O(n + m)O(n+m), where nnn and mmm are the lengths of the two lists.
 */
public class LinkedListMergeSort {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(2, ln1);
        ListNode ln3 = new ListNode(-1, ln2);
        ListNode ln4 = new ListNode(-3, ln3);
        ListNode ln5 = new ListNode(-3, ln4);
        ListNode ln6 = new ListNode(-7, ln5);
        ListNode ln7 = new ListNode(-9, ln6);

        ListNode ln8 = new ListNode(4);
        ListNode ln9 = new ListNode(2, ln8);
        ListNode ln10 = new ListNode(-3, ln9);
        ListNode ln11 = new ListNode(-5, ln10);
        ListNode ln12 = new ListNode(-6, ln11);
        ListNode ln13 = new ListNode(-6, ln12);
        ListNode ln14 = new ListNode(-7, ln13);
        ListNode ln15 = new ListNode(-7, ln14);

        LinkedListMergeSort solution = new LinkedListMergeSort();
        solution.mergeTwoLists(ln7, ln15);

        System.out.println("Single-Linked List Merge Sort: ");

        printListNodes(ln7);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 != null && list2 != null){
            if(list1.getVal() < list2.getVal()){
                list1.setNext(mergeTwoLists(list1.getNext(), list2));
                return list1;
            }
            else{
                list2.setNext(mergeTwoLists(list1, list2.getNext()));
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        } else {
            return list1;
        }
    }

    static void printListNodes(ListNode listNode) {
        System.out.print(listNode.getVal() + " ");
        if (listNode.getNext() != null) {
            printListNodes(listNode.getNext());
        }
    }
}
