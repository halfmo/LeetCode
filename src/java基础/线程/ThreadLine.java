import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThreadLine {
    private static List<Object> list = new ArrayList<>();
    public static void main(String[] args){
        Thread c1 = new Thread(ThreadLine::add);
        c1.setName("厨师1");
        Thread c2 = new Thread(ThreadLine::add);
        c2.setName("厨师2");

        c1.start();
        c2.start();
        Thread s1 = new Thread(ThreadLine::take);
        s1.setName("顾客1");
        Thread s2 = new Thread(ThreadLine::take);
        s2.setName("顾客2");
        Thread s3 = new Thread(ThreadLine::take);
        s3.setName("顾客3");

        s1.start();
        s2.start();
        s3.start();

    }
    private static void add(){
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (list){
                list.add(new Object());
                System.out.println(new Date() +Thread.currentThread().getName()+"添加了新的菜");
                list.notify();
                //list.notifyAll();
            }
        }

    }
    private static void take(){
        while (true){
            try {
                synchronized (list){
                    while (list.isEmpty())list.wait();
                    System.out.println(new Date() +Thread.currentThread().getName()+"拿走了新的菜");
                    list.remove(0);
                }
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
