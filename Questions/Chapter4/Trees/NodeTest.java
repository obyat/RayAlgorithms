package Chapter4.Trees;
//Testing references between two NodeTests
public class NodeTest {
    public int val;
    public NodeTest left;
    public NodeTest right;
    public NodeTest next;

    public NodeTest() {}

    public NodeTest(int _val) {
        val = _val;
    }

    public NodeTest(int _val, NodeTest _left, NodeTest _right, NodeTest _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {
        NodeTest first = new NodeTest(0);
        NodeTest second = first;
        System.out.println("Both initialized to 0: ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);

        System.out.println();
        first = new NodeTest(1000);
        System.out.println("Set first to new NodeTest(1000): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);

        System.out.println();
        first = new NodeTest(0);
        second = first;
        System.out.println("values have been reset");

        System.out.println();
        second.next = new NodeTest(83);
        System.out.println("Set second.next to 83 with left to new NodeTest(8), and right to new NodeTest(8): ");
        second.left = new NodeTest(8);
        second.right = new NodeTest(8);
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
        second = new NodeTest(25);
        second.left = new NodeTest(25);
        second.right = new NodeTest(25);
        System.out.println(
                "Set second to a >>>new NodeTest(25)<<< (no longer references first in memory with left to new NodeTest(25), and right to new NodeTest(25): ");
        System.out.println("second's val: " + second.val);
        System.out.println("first's val: " + first.val);
        System.out.println("second's left: " + second.left.val);
        System.out.println("first's left: " + first.left.val);
        System.out.println("second's right: " + second.right.val);
        if (second.next != null) {
            System.out.println("second.next: " + second.next.val);
        } else {
            System.out.println("second.next is null");
        }
        if (first.next != null) {
            System.out.println("first.next: " + first.next.val);
        } else {
            System.out.println("first.next is null");
        }
        System.out.println();
        System.out.println("Take aways:");
        System.out.println("changing second's fields (next, val, left, right) changes first's fields:");
        System.out.println(
                "changing second's next does not change first's val because that field has not been modified:");
        System.out.println(
                "removing the reference between first and second by setting second to a new NodeTest allows second to be modified without mutating first:");

        System.out.println();
        first.next = new NodeTest(-2);
        System.out.println("Set first.next to new NodeTest(-2): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        if (second.next != null) {
            System.out.println("second.next: " + second.next.val);
        } else {
            System.out.println("second.next is null");
        }
        if (first.next != null) {
            System.out.println("first.next: " + first.next.val);
        } else {
            System.out.println("first.next is null");
        }

        System.out.println();
        first = new NodeTest(0);
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
        first.next = new NodeTest(30);
        System.out.println("Set first.next to new NodeTest(30): ");
        System.out.println("second next: " + second.next.val);
        System.out.println("first next: " + first.next.val);

        System.out.println();
        first = new NodeTest(1000);
        System.out.println("Set first to new NodeTest(1000): ");
        System.out.println("second: " + second.val);
        System.out.println("first: " + first.val);
        if (second.next != null) {
            System.out.println("second.next: " + second.next.val);
        } else {
            System.out.println("second.next is null");
        }
        if (first.next != null) {
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
        System.out.println(
                "changing first's fields changes seconds fields because they are references to the same address");
        System.out.println("unless first is set to new NodeTest()");

    }
}
