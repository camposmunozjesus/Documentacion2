problema 1

a)

class Sync {
        boolean ready;

        void waitSignal() {
                while (! ready) ;
                ready = false;
        }

        void notifySignal() {
                ready = true;
        }
}

// Keyboard thread
do {
        print("echo> ");
        read line from keyboard
        if (EOF) break;
        write line to socket
        sync.waitSignal();
} while (true);

// Cosole thread
while (read echo line from socket) {
        write echo line to console
        sync.notifySignal();
}

b)

class Mutex {
        AtomicBoolean mutex = new AtomicBoolean();

        void lock() {
                while (mutex.getAndSet(true)) ;
        }

        void unlock() {
                mutex.set(false);
        }
}

// Keyboard thread
do {
        mutex.lock();
        print("echo> ");
        read line from keyboard
        mutex.unlock();
        if (EOF) break;
        write line to socket
} while (true);

// Cosole thread
while (read echo line from socket) {
        mutex.lock();
        write echo line to console
        mutex.unlock();
}

problema 2

public class ControlTresor extends MonitorSC {

     int C;
     int Conc_act;
     Condition esperar;

     public ControlTresor(int C) {
         this.C = C;
         Conc_act = C;
         esperar = newCondition();
     }

     public void entrar_sala(int nivell_concentracio) {
         mon_enter();
         Conc_act = Conc_act + nivell_concentracio;
         esperar.cond_signalAll();
         mon_exit();
     }

     public void sortir_sala(int nivell_concentracio) {
         mon_enter();
         while (Conc_act - nivell_concentracio < C) {
             esperar.cond_wait();
         }
         Conc_act = Conc_act - nivell_concentracio;
         mon_exit();
     }
}

problema 3

interface Comms {
    public static int INICI = 100;

    public static int ENTRAR = 10;
    public static int SORTIR = 11;
    public static int OK_SORTIR = 11;

    public static String HOST = "localhost";
    public static int PORT = 2222;
}

interface ControlVigilancia{
    public void enter(int c);
    public void exit(int c);
}

//Monitor execici 3
class ControlVigilanciaReal implements ControlVigilancia {
    public ControlVigilanciaReal(int i){}
    public void enter(int c){}
    public void exit(int c){}
}

public class ServidorVigilancia extends Thread{
    protected ServerSocket benvingut;
    protected ControlVigilanciaReal controlVigilancia;

    public ServidorVigilancia(){
        controlVigilancia = new ControlVigilanciaReal(Comms.INICI);
    }

    public void run(){
        while(true){
            Socket remot = null;
            try {
                benvingut = new ServerSocket(Comms.PORT);
                remot = benvingut.accept();
                new Ajudant(remot,controlVigilancia).start();
            } catch (IOException ignorar) {}
       }
    }

    public static void main(String[] args) {
        new ServidorVigilancia().start();
    }
}

class Ajudant extends Thread{
    protected Socket remot;
    protected DataInputStream entrada;
    protected DataOutputStream sortida;
    protected ControlVigilanciaReal controlVigilancia;

    public Ajudant(Socket remot, ControlVigilanciaReal control) {
        this.remot = remot;
        try {
            entrada = new DataInputStream(remot.getInputStream());
            sortida = new DataOutputStream(remot.getOutputStream());
        } catch (IOException ignorar) {}
        this.controlVigilancia = control;
    }

    public void run(){
        while(true){
            try {
                int accio = entrada.readInt();
                int conc = entrada.readInt();
                if(accio == Comms.ENTRAR){
                    controlVigilancia.enter(conc);
                }else{
                    controlVigilancia.exit(conc);
                    sortida.writeInt(Comms.OK_SORTIR);
                }
            } catch (IOException ignorar) {}
        }
    }
}

class Client extends Thread{
    protected ControlVigilancia controlVigilancia;
    protected int nivell;

    public Client(int conc) {
        controlVigilancia = new RepresentantControlVigilancia();
        nivell = conc;
    }

    public void run(){
        while(true){
            controlVigilancia.enter(nivell);
            // vigila
            controlVigilancia.exit(nivell);
        }
    }

}

class RepresentantControlVigilancia implements ControlVigilancia{
    protected Socket endoll;
    protected DataInputStream entrada;
    protected DataOutputStream sortida;

    public RepresentantControlVigilancia() {
        try {
            endoll = new Socket(Comms.HOST, Comms.PORT);
            entrada = new DataInputStream(endoll.getInputStream());
            sortida = new DataOutputStream(endoll.getOutputStream());
        } catch (IOException ignorar) {}
    }

    public void enter(int conc) {
        try {
            // demano per entrar
            sortida.writeInt(Comms.ENTRAR);
            sortida.writeInt(conc);
            // no espero, segur que puc entrar
        } catch (IOException ignorar) {}
    }

    public void exit(int conc) {
        try {
            // indico que surto
            sortida.writeInt(Comms.SORTIR);
            sortida.writeInt(conc);
            // espero, a poder sortir
            entrada.readInt();
        } catch (IOException ignorar) {}
    }
}

problema 4

a) GestiÃ³ dels ACKs del TCP:
   - reconeixement acumulatiu amb els ACKs
   - enviament d'un ACK cada dos paquets de dades
   - activaciÃ³ del mecanisme fast-retransmission en rebre ACKs triplicats

b) Control de congestiÃ³ del TCP:
   EnumeraciÃ³ dels tres estats possibles:
   - slow start
   - congestion avoidance/AIMD (Additive Increase, Multiplicative Decrease)
   - fast-recovery
   ExplicaciÃ³ de les transicions entre estats i gestiÃ³ de la mida de la
   finestra de transmissiÃ³ en cada estat.
   IdentificaciÃ³ explÃ­cita de les dues situacions diferenciades de
   transiciÃ³ entre estats: time-out / recepciÃ³ d'ACKs triplicats  

