import java.util.ArrayList;
import java.util.List;

public class NumberProcessorTest {
private int num;                   // змінна лічильника

    public NumberProcessorTest(int num) {  // конструктор
        this.num = num;                   // приймаэмо число
        processNumbers(num);              // викликаэмо метод
    }
    public static void processNumbers(int num) {  //  метод по переробкі чисел
        NumberProcessor npFizz = new NumberProcessor((n)->{ // створюємо наш клас по суті процес що перевіряє умову задачі
            if (n%3==0&& n%5!=0){                           // якщо умова виконується
                System.out.println("fizz");       //друкується рядок
            }
        });
        NumberProcessor npBazz = new NumberProcessor((n)->{
            if (n%5==0&& n%3!=0){
                System.out.println("bazz");
            }
        });
        NumberProcessor npFizzBazz = new NumberProcessor((n)->{
            if (n%5==0 && n%3==0){
                System.out.println("fizz bass");
            }
        });
        NumberProcessor npNotFizBazz = new NumberProcessor((n)->{
            if (n%5!=0 && n%3!=0){
                System.out.println(n);
            }
        });

        List<NumberProcessor> threds= new ArrayList<>();   // створюємо масив потоків щоб зручніше було працювать
        threds.add(npFizzBazz);
        threds.add(npNotFizBazz);
        threds.add(npBazz);
        threds.add(npFizz);

        for(NumberProcessor t: threds){              // запускаємо масив потоків що створили вище
            t.start();
        }
        for(int i  = 1; i<=num; i++){        // цей цикл це посуті лічильник що відпрацьовує від 1 до 100
            for(NumberProcessor t: threds){  // перша ітерація це роздача числа лічильника процесам
                t.process(i);                // процесам потоків що в масиві, передаємо і
            }
            while (true){                      // безкінечний цикл Друга ітеряція лічильника
                int processed = 0;             //  створюємо змінну щоб бачити скільки процесів ми запустили
                for(NumberProcessor t: threds){  // знову ітеруємось по масиву процесів
                    if (t.isNProcesed()){         // перевіряючи чи обробив процес з число
                         processed++;             // додаємо 1 до кількості процесів що обробляють число
                    }
                }
                if(processed==threds.size()){              // якщо кількість процесів що обробили число, зрівнялася з  довжиною масива запущених процксів
                    break;                     // покидаємо цикл вайл переходимо на наступну ітеацію лічильника
                }
            }
        }
    }
}

