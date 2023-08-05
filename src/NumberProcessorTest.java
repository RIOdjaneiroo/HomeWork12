import java.util.ArrayList;
import java.util.List;

public class NumberProcessorTest {
    public static void main(String[] args) {
        NumberProcessor npFizz = new NumberProcessor((n)->{
            if (n%3==0&& n%5!=0){
                System.out.println("fizz");
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

        List<NumberProcessor> threds= new ArrayList<>();
        threds.add(npFizzBazz);
        threds.add(npNotFizBazz);
        threds.add(npBazz);
        threds.add(npFizz);

        for(NumberProcessor t: threds){
            t.start();
        }
        for(int i  = 1; i<100; i++){
            for(NumberProcessor t: threds){
                t.process(i);
            }
            while (true){
                int processed = 0;
                for(NumberProcessor t: threds){
                    if (t.isNProcesed()){
                        processed++;
                    }
                }
                if(processed==4){
                    break;
                }
            }
        }

    }
}

