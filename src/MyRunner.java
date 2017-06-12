/**
 * Created by max on 12/06/17.
 */
public class MyRunner extends Runner {
    public MyRunner(String nome, Pista p, int delay) { super(nome, p, delay); }

    @Override
    public void run() {
        p.step();  //Primissimo passo nella corsa
        while(p.getNext() != null || this.isInterrupted()) {  //A meno che non è arrivato o la corsa è finita
            try {
                sleep(delay);  //Attesa prima di compiere una qualunque azione
                p.leave();  //Lascio la posizione precedente
                p = p.getNext();  //Imposto il prossimo passo
                p.step();  //Metto piede nella posizione successiva
            } catch (InterruptedException ignore) {System.out.println(this.getName()+": Ho perso!"); }
        }
        System.out.println(this.getName()+" è arrivato!");
        this.interrupt();
    }
}
