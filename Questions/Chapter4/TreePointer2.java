
class TreePointer2 {

    
    public Node connect(Node root){
       if(root == null) return root;
       Node head = root;

       while(head != null){

          Node dummy = new Node();
          Node temp = dummy;
          
          while(head != null){
          
             if(head.left != null){
             
                temp.next = head.left;
                temp = temp.next;
             }
             
             if(head.right!=null){
                temp.next = head.right;
                temp = temp.next;
             }
             head = head.next;
          }

       }
          return root;
    }
}

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
        TreePointer2 s = new TreePointer2();
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.right = new Node(7);
        System.out.println(s.connect(tree).left.next.val);
    }
}
