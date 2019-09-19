
public class LinkList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode((l1.val+l2.val)%10);

        int carray=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        ListNode cur=res;
        int val=0;
        while(l1!=null||l2!=null){
            int node1=l1!=null?l1.val:0;
            int node2=l2!=null?l2.val:0;
            int tal=carray+node1+node2;
            carray=tal/10;
            val=tal%10;
            cur.next=new ListNode(val);
            cur=cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carray>0){
            cur.next=new ListNode(carray);
        }
        return res;
    }



    public static  void main(String[] args){
        ListNode l1=new ListNode(9);
        //l1.next=new ListNode(2);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);
        l2.next.next.next=new ListNode(9);
        l2.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next=new ListNode(9);
        ListNode res=addTwoNumbers(l1,l2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
