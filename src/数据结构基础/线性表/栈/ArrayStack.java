public class ArrayStack<E> extends AbstractStack<E>{

    //底层数组
    private Object[] arr = new Object[20];
    //长度
    private int size = 0;

    @Override
    public E pop() {
        return (E) arr[(size--)-1];
    }

    @Override
    public void push(E e) {
        if(size >= arr.length){
            Object[] arr = new Object[this.arr.length + 10];
            for (int i = 0; i < this.arr.length; i++) arr[i] = this.arr[i];
            //可以使用下面这个方法，效率更高
            //System.arraycopy(this.arr, 0, arr, 0, arr.length);
            this.arr = arr;
        }
        arr[size++] = e;

    }
    public static void main(String[] args){
//        ArrayStack<String> list = new ArrayStack<>();
//        list.push("A");
//        list.push("B");
//        list.pop();
//        System.out.println("debug");
//        System.out.println(857%10);
        System.out.println(1<<5);
        System.out.println(1&(1<<2));
    }
}
