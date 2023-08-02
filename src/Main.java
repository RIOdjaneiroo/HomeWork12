
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");
        FirstTaskTwoThread firstTaskTwoThread = new FirstTaskTwoThread();  //створюємо обєкта класу
        firstTaskTwoThread.start();  // викликаємо метод start
    }
}