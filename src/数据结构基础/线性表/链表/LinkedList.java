public class LinkedList<E> extends AbstractList<E>{

    private Node<E> head = new Node<>(null);
    private int size;
    @Override
    public int size() {
        return 0;
    }

    /**
     * e0 -> e2
     * e1 -> e2 -> e3
     * e1 -> e0 -> e2 -> e3
     * @param e 元素
     * @param index 要添加的位置(索引)
     */
    @Override
    public void add(E e, int index) {
        if(index > size) {
          throw new IllegalArgumentException("非法插入位置 ");
        }
        Node<E> node = head, temp;
        for (int i = 0; i < index; i++) {
          node = node.next;
        }
        temp = node.next;
        node.next = new Node<>(e);
        node.next.next = temp;

        size++;
    }

    @Override
    public E remove(int index) {
        if(index > size -1) {
          throw new IllegalArgumentException("非法的删除位置");
        }
        Node<E> node = head,temp;
        for (int i = 0; i < index; i++) {
          node = node.next;
        }
        temp = node.next;
        node.next = node.next.next;
        size--;
        return temp.e;

    }

    @Override
    public E get(int index) {
        if (index >= size ) {
          throw new IndexOutOfBoundsException("无法访问到下标位置");
        }
        Node<E> node = head.next;
        for (int i = 0; i < index; i++) {
          node = node.next;
        }
        return node.e;
    }

  @Override
  public void removeLast() {

  }

  @Override
  public <E1> void add(E1 i) {

  }

  private static class Node<E>{
        private E e;
        private Node<E> next;
        public Node(E e){
            this.e = e;
        }

//        public Node() {
//
//        }
    }

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("A",0);
        list.add("B",0);
        //list.remove(0);
        System.out.println(list.get(1));
        System.out.println("debug");
    }
}
