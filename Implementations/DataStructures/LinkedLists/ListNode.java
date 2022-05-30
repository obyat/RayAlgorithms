package DataStructures.LinkedLists;

public class ListNode<T>{
    private T data;
    private ListNode<T> next;

    private ListNode(T data, ListNode<T> next){
        this.data = data;
        this.next = next;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append(data).toString();
    }

    public static void main(String[] args) {
        ListNode<Object> head = new ListNode<Object>(1, null);
        System.out.println(head);
        ListNode<Object> node = new ListNode<Object>("hello", head);
        System.out.println(node);
        System.out.println(node.next);

    }

}