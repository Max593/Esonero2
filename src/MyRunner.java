/**
 * Created by max on 12/06/17.
 */
public class MyRunner extends Runner {
    public MyRunner(String nome, Pista p, int delay) {
        super(nome, p, delay);
    }

    @Override
    public void run() {
        try {
            while (!p.arrivato()) {  //A meno che non è arrivato o la corsa è finita
                p.leave();  //Lascia la posizione su cui si trova
                p = p.getNext();  //Ottiene la posizione successiva
                p.step();  //Si posiziona nella casella successiva
                sleep(delay);  //Attesa
            }
            if (p.arrivato()) {  //Se si è arrivati a destinazione interrompe il thread
                System.out.println(this.getName() + " è arrivato!");
                this.interrupt();
            }
        } catch (InterruptedException ignore) {  //Se viene preso
            System.out.println(this.getName().toUpperCase() + " PRESO!");
        }
    }
}
