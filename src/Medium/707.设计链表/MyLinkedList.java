class LinkNode {
    int val;
    LinkNode next;
    LinkNode prev;

    LinkNode() {
    }

    LinkNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {
    int size;
    LinkNode head, tail;

    public MyLinkedList() {
        head = new LinkNode(0);
        size = 0;
        tail = new LinkNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        LinkNode cur = head;

//        if (index < (size - 1) / 2) {
//            for (int i = 0; i <= index; i++) {
//                cur = cur.next;
//            }
//        } else {
//            cur = tail;
//            for (int i = 0; i <= size - index - 1; i++) {
//                cur = cur.prev;
//            }
//        }
        if (index + 1 < size - index)
            for (int i = 0; i < index + 1; i++) cur = cur.next;

        else {
            cur = tail;
            for (int i = 0; i < size - index; i++) cur = cur.prev;
        }
        return cur.val;
    }

    public void addAtHead(int val) {

        //addAtIndex(0, val);

        LinkNode pre = head, succ = head.next;

        size++;
        LinkNode addNode = new LinkNode(val);
        addNode.prev = pre;
        addNode.next = succ;
        pre.next = addNode;
        succ.prev = addNode;
    }

    public void addAtTail(int val) {
        //addAtIndex(size, val);
        LinkNode pre = tail.prev, succ = tail;
        size++;
        LinkNode addNode = new LinkNode(val);
        addNode.prev = pre;
        addNode.next = tail;
        pre.next = addNode;
        succ.prev = addNode;

    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        LinkNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        LinkNode addNode = new LinkNode(val);
        addNode.next = pre.next;
        pre.next.prev = addNode;
        addNode.prev = pre;
        pre.next = addNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
//        LinkNode pre = head;
//        for (int i = 0; i < index; i++) {
//            pre = pre.next;
//        }
//        pre.next.next.prev = pre;
//        pre.next = pre.next.next;
//        size--;
        LinkNode pre, succ;
        if (index < size - index) {
            pre = head;
            for (int i = 0; i < index; i++) pre = pre.next;
            succ = pre.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index -1; i++) succ = succ.prev;
            pre = succ.prev.prev;
        }
        size--;
        pre.next = succ;
        succ.prev = pre;
    }
}