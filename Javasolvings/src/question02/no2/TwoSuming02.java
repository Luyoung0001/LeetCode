package question02.no2;

/*
* 递归实现
* */
public class TwoSuming02 {
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
        // 遍历结果应该是：1，1，8
        Solution solution = new Solution();
        ListNode ret = solution.addTwoNumbers(l1,h1);
        // 遍历测试：h1.Traverse();
        ret.Traverse();
    }
}
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
    // 额外加一个遍历方法
    public void Traverse() {
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
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null && carry == 0) return null;
        if(l1 != null && l2 == null && carry == 0) return l1;
        else if(l1 == null && l2 != null && carry == 0) return l2;

        // 解决进位的问题
        int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val) + carry;
        carry = sum/10;
        int no = sum % 10;
        ListNode listNode = new ListNode(no);
        listNode.next = addTwoNumbers(l1 == null?null:l1.next,l2 == null?null:l2.next);
        return listNode;

    }
}

