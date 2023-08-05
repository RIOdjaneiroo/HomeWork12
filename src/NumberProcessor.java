import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread{
    private Consumer<Integer> procesor;
    private  int n;
    AtomicBoolean isNProcesed = new AtomicBoolean(true);
    public NumberProcessor(Consumer<Integer> procesor){
        this.procesor = procesor;
    }

    public void process (int n){
        this.n = n;
        isNProcesed.set(false);
    }

    public boolean isNProcesed(){
        return isNProcesed.get();
    }

    @Override
    public void run() {
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(isNProcesed.get()){
                continue;
            }
            procesor.accept(n);
            isNProcesed.set(true);

        }
    }
}

