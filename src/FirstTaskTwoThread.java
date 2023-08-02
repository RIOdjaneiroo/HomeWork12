public class FirstTaskTwoThread {
    public static void main(String[] args) throws InterruptedException {
        FirstTaskTwoThread firstTaskTwoThread = new FirstTaskTwoThread();  //створюємо обєкта класу
        firstTaskTwoThread.start();  // викликаємо метод start

    }

    public void start() throws InterruptedException {  // метод старт обгорнутий у виключення із за сна
        Thread firstThread = new Thread(() -> {     // створюємо новий потік з анонімним класом параметр якого лямбда вираз
            try {
                //Thread.sleep(1000); // затримка перед початком виведення повідомлень не використовується бо не спрацювало
                long startTime = System.currentTimeMillis(); //створюємо змінну з числом Start роботи програми
                while (true) {                               // вічний цикл
                    long currentTime = System.currentTimeMillis();     // створюємо змінну  з поточним часом
                    long sumTime = (currentTime+1000 - startTime) / 1000; // рахуємо з тисячі щоб не виводити 0
                    System.out.println("Програма працює " + sumTime + " секунд"+ " з потоку "+Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();     // повідомлення про вийняток
            }
        });

        Thread secondThread = new Thread(() -> {    // створюємо новий потік з анонімним класом
            try {
                Thread.sleep(5000); // затримка перед початком виведення повідомлень
                while (true) {            // вічний цикл
                    System.out.println("Минуло 5 секунд в потоці " + Thread.currentThread().getName() ); //виведення повідомлення з потоку
                    Thread.sleep(5000);   // затримка на 5 секунд в циклі щоб виводити своєчасно повідомлення
                }
            } catch (InterruptedException e) {
                e.printStackTrace();  // повідомлення про вийняток
            }
        });
//Thread.sleep(1000);
        firstThread.start();     // стартуємо потік
        secondThread.start();    // стартуємо потік
    }
}


