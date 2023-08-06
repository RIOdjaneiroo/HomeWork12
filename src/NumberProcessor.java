import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread{
    private Consumer<Integer> procesor;   // створюємо змінну типу Consumer функція що приймає інт
    private  int n;                     // створюємо змінну число яке будемо приймати в процес
    private AtomicBoolean isNProcesed = new AtomicBoolean(true); //ствЗм що вказуэ чи обробив процес число  n
    public NumberProcessor(Consumer<Integer> procesor){  // конструктор класу що приймаэ типу функцыю
        this.procesor = procesor;
    }

    public void process (int n){      // процес що приймаэ число  і каже що воно в обробці
        this.n = n;
        isNProcesed.set(false);
    }

    public boolean isNProcesed(){
        return isNProcesed.get();
    } // метод для отримання стану процесу

    @Override
    public void run() {
        while (true){  //безкінечний цикл
            try {
                sleep(100);                         // короткий сон, працює і без нього але зі сном приємні
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(isNProcesed.get()){   // якщо передана змінна оброблена то переходимо  на новий виток циклу
                continue;
            }                     // якщо ж ні
            procesor.accept(n);    // передаємо інт в процесор а точніше в консруктор нашого класу через метод accept
            isNProcesed.set(true);  // ставимо чек що вона (змінна) оброблена

        }
    }
}

