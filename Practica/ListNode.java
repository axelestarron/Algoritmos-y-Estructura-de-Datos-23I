  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {this.val=-1;}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      
      public boolean empty(){
          return this.val==-1;
      }
      
      public int pop(){
          //it only does the method if the list is not empty
          int temp=this.val;
          if(this.next!=null){
            this.val=this.next.val;
            this.next=this.next.next;
          }else{
            this.val=-1;
          }
          return temp;
          
      }
      public void push(int pushed){
          if(!this.empty()){
            this.next=new ListNode(this.val,this.next);
            this.val=pushed;
          }else{
              this.val=pushed;
          }
      }
      public static void main(String[] args){
        ListNode a=new ListNode();
        int[] myArray={1,2,3,4};
        for(int i=0;i<myArray.length;i++){
            a.push(myArray[i]);
        }
        while(!a.empty()){
            System.out.println(a.pop());
        }
        System.out.println(a.empty());
      }
 }
 
class Solution {
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
          }
          return temp;
          
      }
      public static void push(ListNode myList,int pushed){  
        myList.next=new ListNode(myList.val,myList.next);
        myList.val=pushed;
      }

    public static int power(int x, int p){
        if(p==0){
            return 1;
        }
        int power=1;
        for(int i=0;i<p;i++){
            power=power*x;
        }
        return power;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode();
        int sum=0;
        int power10=-1;
        while(!empty(l1) || !empty(l2)){
            power10++;
            if(empty(l1)){
                sum+=(pop(l2)*power(10, power10));
            }else if(empty(l2)){
                sum+=(pop(l1)*power(10, power10));
            }else{
                sum+=(pop(l1)*power(10, power10))+(pop(l2)*power(10, power10));
            } 
        }
        int currentDigit;
        while(power10>-1){
            currentDigit=sum/power(10,power10);
            push(result,currentDigit);
            sum-=currentDigit*power(10,power10);
            power10--;
        }
        return result;
    }

    public static void main(String[] args){
        ListNode a=new ListNode();
        ListNode b=new ListNode();
        int[] firstArray={1,2,3,4};
        int[] secondArray={2,3,5,7,8};
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
}