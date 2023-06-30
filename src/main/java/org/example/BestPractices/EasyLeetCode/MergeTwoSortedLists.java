package org.example.BestPractices.EasyLeetCode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        list1.next = n2;
        n2.next = n3;

        ListNode list2 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        list2.next = n5;
        n5.next = n6;

        ListNode result = mergeTwoLists(list1, list2);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode tempNode = new ListNode(0);
        ListNode currentNode = tempNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }

        if (list1 != null) {
            currentNode.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            currentNode.next = list2;
            list2 = list2.next;
        }

        return tempNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
