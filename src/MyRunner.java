/**
 * Created by max on 12/06/17.
 */
public class MyRunner extends Runner {
    public MyRunner(String nome, Pista p, int delay) { super(nome, p, delay); }

    @Override
    public void run() {
        while(!this.isInterrupted()) {  //A meno che non è arrivato o la corsa è finita
            try {
                sleep(delay);
                p.leave();
                p = p.getNext();
                p.step();
                if(p.arrivato()) {
                    System.out.println(this.getName()+" è arrivato!");
                    this.interrupt();
                }
            } catch (InterruptedException ignore) { System.out.println(this.getName()+": Ho perso!"); }
        }
    }
}
