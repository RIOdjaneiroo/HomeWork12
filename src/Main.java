
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome!");
         FirstTaskTwoThread firstTaskTwoThread = new FirstTaskTwoThread();  // перша задача створюємо обєкта класу
         firstTaskTwoThread.start();                                       // викликаємо метод start
        NumberProcessorTest.processNumbers(100);   //   Друга Задача
        System.exit(0);                     //  якось так закриваэмо бо не закриваэться

    }
}