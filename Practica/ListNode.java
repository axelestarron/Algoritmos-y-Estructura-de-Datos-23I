  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public static boolean empty(ListNode myList){
          return myList.val==0 && myList.next==null;
      }
      
      public static int pop(ListNode myList){
          //it only does the method if the list is not empty
          int temp=myList.val;
          if(myList.next!=null){
            myList.val=myList.next.val;
            myList.next=myList.next.next;
          }else{
              myList.val=0;
          }
          return temp;
      }
      public static void push(ListNode myList,int pushed){
          myList.next=new ListNode(myList.val,myList.next);
          myList.val=pushed;
      }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempStack=new ListNode();
        int sum=0;
        int carry=0;
        while(!empty(l1) || !empty(l2)){
            if(empty(l1)){
                sum=pop(l2)+carry;
            }else if(empty(l2)){
                sum=pop(l1)+carry;
            }else{
                sum=pop(l1)+pop(l2)+carry;
            }

            if(sum<10){
              carry=0;
            }else{
              carry=1;
              sum=sum-10;
            }
            System.out.println(sum+" "+carry);
            push(tempStack, sum);
        }
        
        if(carry!=0){
          push(tempStack,carry);
        }
        System.out.println(tempStack.val);
        ListNode result=new ListNode();
        while(!empty(tempStack)){
            if(empty(result)){
                result.val=pop(tempStack);
            }else{
                push(result,pop(tempStack));
            }
        }

        return result;
    }

    public static void main(String[] args){
        ListNode a=new ListNode();
        ListNode b=new ListNode();
        int[] firstArray={0};
        int[] secondArray={0};
        for(int i=0;i<firstArray.length;i++){
            push(a,firstArray[i]);
        }
        for(int i=0;i<secondArray.length;i++){
            push(b,secondArray[i]);
        }
        ListNode c=addTwoNumbers(a,b);
        while(!empty(c)){
            System.out.println(pop(c));
        }
      }
}
