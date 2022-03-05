public class ArrayList <E> extends AbstractList<E>{
    //底层数组
    private Object[] arr = new Object[20];
    //长度
    private int size = 0;
    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {
        if(index > size)throw new IllegalArgumentException("非法插入位置 ");

        if(size >= arr.length){
            Object[] arr = new Object[this.arr.length + 10];
            for (int i = 0; i < this.arr.length; i++) arr[i] = this.arr[i];
            //可以使用下面这个方法，效率更高
            //System.arraycopy(this.arr, 0, arr, 0, arr.length);
            this.arr = arr;
        }
        int i = size - 1;
        while(i >= index) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[index] = e;
        size++;
    }

    @Override
    public E remove(int index) {
        if(index > size -1) throw new IllegalArgumentException("非法的删除位置");
        int i = index;
        E e = (E) arr[index];
        while(i < size){
            arr[i] = arr[i+1];
            i++;
        }
        size--;
        return e;
    }

    @Override
    public E get(int index) {
        if (index >= size ) throw new IndexOutOfBoundsException("无法访问到下标位置");
        return (E) arr[index];
    }
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("A",0);
        list.add("B",0);
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println("debug");
    }
}
