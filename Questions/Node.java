//Testing references between two nodes
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {
        Node first = new Node(0);
        Node second = first;
        System.out.println("Both initialized to 0: ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        
        
        System.out.println();
        first = new Node(1000);
        System.out.println("Set first to new Node(1000): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);

        System.out.println();
        first = new Node(0);
        second = first;
        System.out.println("values have been reset");
        
        System.out.println();
        second.next = new Node(83);
        System.out.println("Set second.next to 83 with left to new Node(8), and right to new Node(8): ");
        second.left = new Node(8);
        second.right = new Node(8);
        System.out.println("second's val: " + second.val);
        System.out.println("first's val: " + first.val);
        System.out.println("second's left: " + second.left.val);
        System.out.println("first's left: " + first.left.val);
        System.out.println("second's right: " + second.right.val);
        System.out.println("first's right: " + first.right.val);
        System.out.println("second next: " + second.next.val);
        System.out.println("first next: " + first.next.val);
    
        
        System.out.println();
        System.out.println("Set second.val to -5: (manipulation of field val) ");
        second.val = -5;
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        System.out.println("second next: " + second.next.val);
        System.out.println("first next: " + first.next.val);
        
        System.out.println();
        second = new Node(25);
        second.left = new Node(25);
        second.right = new Node(25);
        System.out.println("Set second to a >>>new Node(25)<<< (no longer references first in memory with left to new Node(25), and right to new Node(25): ");
        System.out.println("second's val: " + second.val);
        System.out.println("first's val: " + first.val);
        System.out.println("second's left: " + second.left.val);
        System.out.println("first's left: " + first.left.val);
        System.out.println("second's right: " + second.right.val);
            if(second.next != null){
                System.out.println("second.next: " + second.next.val);
                } else {
                    System.out.println("second.next is null");
            }
            if(first.next != null){
                System.out.println("first.next: " + first.next.val);
                } else {
                    System.out.println("first.next is null");
            }
        System.out.println();
        System.out.println("Take aways:");
        System.out.println("changing second's fields (next, val, left, right) changes first's fields:");
        System.out.println("changing second's next does not change first's val because that field has not been modified:");
        System.out.println("removing the reference between first and second by setting second to a new node allows second to be modified without mutating first:");
        
        System.out.println();
        first.next = new Node(-2);
        System.out.println("Set first.next to new Node(-2): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
            if(second.next != null){
                System.out.println("second.next: " + second.next.val);
                } else {
                    System.out.println("second.next is null");
            }
            if(first.next != null){
                System.out.println("first.next: " + first.next.val);
                } else {
                    System.out.println("first.next is null");
            }

        System.out.println();
        first = new Node(0);
        second = first;
        System.out.println("values have been reset");
        
        System.out.println();
        first.val = 34455;
        System.out.println("Set first.val to 34455: ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        
        System.out.println();
        second.val = -1;
        System.out.println("Set second.val to -1 : ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        
        System.out.println();
        first.next = new Node(30);
        System.out.println("Set first.next to new Node(30): ");
        System.out.println("second next: " + second.next.val);
        System.out.println("first next: " + first.next.val);

        System.out.println();
        first = new Node(1000);
        System.out.println("Set first to new Node(1000): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
            if(second.next != null){
                System.out.println("second.next: " + second.next.val);
                } else {
                    System.out.println("second.next is null");
            }
            if(first.next != null){
                System.out.println("first.next: " + first.next.val);
                } else {
                    System.out.println("first.next is null");
            }

            
        System.out.println();
        second.val = -100;
        System.out.println("Set second.val to -100 : ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);


        System.out.println();
        System.out.println("Take aways:");
        System.out.println("changing first's fields changes seconds fields because they are references to the same address");
        System.out.println("unless first is set to new Node()");
    
    
    }
}
