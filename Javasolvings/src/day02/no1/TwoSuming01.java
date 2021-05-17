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
        /*ListNode ret = Solution.addTwoNumbers(l1,h1);
        while(ret.next != null){
            System.out.println(ret.val);
            ret = ret.next;
        }*/
        ListNode c = Solution.changeList(2345);
        /*while(c.next != null){
            System.out.println(c.val);
        }*/
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

}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int count1 = 0;
        int a = 0;
        int count2 = 0;
        int b = 0;
        int sum = 0;
        int count3 = 0;
        while(l1.next != null){
            count1 ++;
            a = a + l1.val * (10^(count1-1));
            l1 = l1.next;
        }
        while(l2.next != null){
            count2 ++;
            b = b + l1.val * (10^(count2-1));
            l2 = l2.next;
        }
        sum = a + b;
        System.out.println(sum);
        // 递归
        return changeList(sum);
    }
    public static ListNode changeList(int c){
        while(true){
            int counter = 0;
            counter++;
            int temp = (int)(c%(Math.pow(10,counter)));
            int temp1 = (int)(c/(Math.pow(10,counter)));
            if(temp1 == 0){
                return new ListNode(c,null);
            }
            return new ListNode(temp,changeList(temp1));

        }
    }
}