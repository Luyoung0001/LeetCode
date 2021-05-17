package day02.no1;

public class TwoSuming01 {
    public static void main(String[] args) {
        // 第一个链表:7-->3-->2
        ListNode l3 = new ListNode(2,null);
        ListNode l2 = new ListNode(3,l3);
        ListNode l1 = new ListNode(7,l2);
        // 第二个链表:4-->7-->5
        ListNode h3 = new ListNode(5,null);
        ListNode h2 = new ListNode(7,h3);
        ListNode h1 = new ListNode(4,h2);
        // 结果应该是：1-->1-->8
        // 打印结果应该是：8，1，1
        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(l1,h1);
        // h1.Traverse();
        ret.Traverse();

    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
    public void Traverse(){
        ListNode current = this;
        if(this == null){
            return;
        }
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }

}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 将最后的进位写进链表
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }
}