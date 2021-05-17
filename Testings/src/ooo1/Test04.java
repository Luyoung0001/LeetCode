package ooo1;

public class Test04 {
    public static void main(String[] args) {
        ListNode node = null;
        System.out.println(node);
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
