import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class inputAndOutput {
    private static List<Book> LIST = new ArrayList<>();
    public static void main(String[] args){
        ReadData();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("==========图书馆系统==========");
            System.out.println("1.插入数据");
            System.out.println("2.修改信息");
            System.out.println("3.查询图书列表");
            System.out.println("4.删除图书");
            System.out.println("（按其他任意键退出系统）");
            String str = scanner.nextLine();
            switch (str){
                case "1":
                    InsertBook(scanner);
                    break;
                case "2":
                    AlterBook(scanner);
                    break;
                case "3":
                    ShowBooks();
                    break;
                case "4":
                    DeleteBook(scanner);
                    break;
                default:
                    SaveData();
                    scanner.close();
                    return;
            }
        }

    }
    @SuppressWarnings("unchecked")
    private static void ReadData(){
        File file = new File("data");
        if (file.exists()){
            try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data"))){
                LIST = (List<Book>) inputStream.readObject();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }else {
            LIST = new ArrayList<>();
        }

    }
    private static void SaveData(){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data"))){
            outputStream.writeObject(LIST);
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void AlterBook(Scanner scanner){
        int i = 0;
        for (Book book :LIST){
            System.out.println(i + "." + book);
        }
        int Index = scanner.nextInt();
        scanner.nextLine();
        if (Index > LIST.size()) System.out.println("error Index");
        else {
            LIST
                    .get(Index)
                    .name(scanner.nextLine())
                    .author(scanner.nextLine())
                    .price(scanner.nextDouble());
        }
        scanner.nextLine();
    }
    private static void DeleteBook(Scanner scanner){
        int i = 0;
        for (Book book :LIST){
            System.out.println(i + "." + book);
        }
        int Index = scanner.nextInt();
        if (Index > LIST.size()) System.out.println("error Index");
        else LIST.remove(i);
        scanner.nextLine();
    }
    private static void ShowBooks(){
        LIST.forEach(System.out::println);
    }

    private static void InsertBook(Scanner scanner){
        LIST.add(new Book()
                .name(scanner.nextLine())
                .author(scanner.nextLine())
                .price(scanner.nextDouble()));
        scanner.nextLine();
    }
    private static class Book implements Serializable{
        String name;
        String author;
        double price;

        public Book name(String name){
            this.name = name;
            return this;
        }
        public Book author(String author){
            this.author = author;
            return this;
        }
        public Book price(Double price){
            this.price = price;
            return this;
        }

        @Override
        public String toString() {
            return "书籍{" +
                    "名称='" + name + '\'' +
                    ", 作者='" + author + '\'' +
                    ", 价格=" + price +
                    '}';
        }
        //        public Book(String name, String author, double price) {
//            this.name = name;
//            this.author = author;
//            this.price = price;
//        }
    }
}
