class DoublyLinkedList{
    DllNode head;

    public DoublyLinkedList(DllNode head){
        this.head = head;
    }

    void addToEnd(int data){
        DllNode n = new DllNode(data);

        if(head == null){
            head = n;
        } else{
            DllNode curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = n;
            n.prev = curr;
        }
    }

    //O(1)
    void addToStart(int data){
        DllNode n = new DllNode(data);

        if(head == null){
            head = n;
        } else{
            //location of start is known as first node in linkedlist
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    //O(n)
    void addAfter(DllNode curr, int insertAfter, int data){
        if(curr == null) return;
        if(curr.data == insertAfter){
            DllNode n = new DllNode(data);
            if(curr.next != null){
                curr.next.prev = n;
                n.next = curr.next;
            }
            curr.next = n;
            n.prev = curr;
        } else{
            addAfter(curr.next, insertAfter, data);
        }
    }

    //O(n)
    DllNode deletelast(){
        DllNode toDelete = head;
        if(head == null || head.next == null){
            head = null;
            return toDelete;
        }
        while(toDelete.next != null){
            toDelete = toDelete.next;
        }
        return toDelete.prev.next = null;
    }
    
    //O(1)
    DllNode deleteStartNode(){
        DllNode toDelete = head;
        if(head == null || head.next == null){
            head = null;
            return toDelete;
        }
        head = head.next;
        head.prev = null;
        return toDelete;
    }

    //O(n)
    DllNode deleteAfter(int data){
        DllNode toDelete = head;
        for(; toDelete != null; toDelete = toDelete.next){
            if(toDelete.data == data){
                toDelete = toDelete.next;
                break;
            }
        }
        if(toDelete != null){
            if(toDelete.next != null){
                toDelete.next.prev = toDelete.prev;
            }
            toDelete.prev.next = toDelete.next;
        }
        return toDelete;
    }

    public static void main(String[] args) {
        DllNode head = new DllNode(5);
        DllNode after = new DllNode(7);
        head.next = after;
        after.prev = head;
        DllNode before = new DllNode(3);
        head.prev = before;
        before.next = head;

        // before.PrintLinkedList();
        DoublyLinkedList ddl = new DoublyLinkedList(before);
        // ddl.addToStart(1);
        // ddl.addToStart(0);

        // ddl.addToEnd(10);
        // ddl.addToEnd(100);
        
        // ddl.deletelast();
        // ddl.deleteStartNode();
        // ddl.head.PrintLinkedList();
        DllNode t1 = new DllNode(100);
        DoublyLinkedList ddl1 = new DoublyLinkedList(t1);
        ddl1.addToEnd(101);
        ddl1.addToEnd(102);
        ddl1.addAfter(ddl1.head, 102, 1022);
        ddl1.addToEnd(103);
        ddl1.addToStart(99);
        ddl1.head.PrintLinkedList();
    }
}