import Eventi.Concerto;
import Eventi.Evento;
import ProgrammaEventi.ProgrammaEventi;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {

      // Introduzione 

       Scanner scan=new Scanner(System.in);
       System.out.println("Creare un nuovo evento inserendo i seguenti parametri:\n"
                 + "- Titolo\n"
                 +"- Data\n"
                 +"- numero di posti totale.");

      System.out.println("scegli il nome da dare all'evento");
      String nomeE1 = scan.nextLine();

      // dichiiarazione delle variabili da sovrascrivere nel costruttore

      LocalDate dataE1= null;
      int numeroPostiTotale1=0;
      boolean numeValido=false;

      // gestione eccezioni e validazione del dato inserito dall'utente per data e numeroPosti

      while (dataE1==null){
        System.out.println("scegli in che data fare l'evento(nel formato yyyy-MM-dd)");
        String data=scan.nextLine();
        
        try {
            dataE1=LocalDate.parse(data);
            
        } catch (DateTimeParseException e){
            System.out.println("formato inserito non valido");
        }
        
      }
      while(numeValido==false){
        System.out.println("scegli il numero totale di posti per l'evento(il numero deve essere maggiore di 0)");
         try {
           numeroPostiTotale1=scan.nextInt();
           scan.nextLine();
           if(numeroPostiTotale1>0){
             numeValido=true;
           }else{
            System.out.println("il numero deve essere maggiore di 0");
           }

         } catch (InputMismatchException e) {
            System.out.println("inserimento numerico non valido");
         }
      }
      
      Evento e1= new Evento(nomeE1, dataE1, numeroPostiTotale1);

      // gestione eccezioni e validazioni del dato inserito per i metodi prenota() e disdici()

      System.out.println("vuoi fare delle prenotazioni per l'evento?(rispondere con 'si' o 'no')");
      String sceltaPrenotazioni=scan.nextLine();
      if(sceltaPrenotazioni.equalsIgnoreCase("si")){
        while(true){
          System.out.println("scegliere il numero di posti da prenotare");
          try{
              int sceltaNumPosti=scan.nextInt();
              scan.nextLine();
              if(sceltaNumPosti>0){
                for(int i=0;i<sceltaNumPosti;i++){
                e1.prenota();
                
                }
              }else{
                System.out.println("scelta non valida");
              }
          }catch(InputMismatchException e){
            System.out.println("inserisci un numero vallido");
            scan.nextLine();
            continue;
          }  
          System.out.println("vuoi fare altre prenotazioni? (rispondere con 'si' o 'no')");
          String sceltaPrenotazioni2 = scan.nextLine();
          if (sceltaPrenotazioni2.equalsIgnoreCase("no")) {
              break;
          }
        }
      }else{
        System.out.println("nessuna prenotazione verrà effetuata");
      }
      System.out.println("il numero di posti totali del'evento sono "+e1.getNumeriPostiTotale()+", di cui disponibili "+e1.postiDisponibili());

      System.out.println("vuoi fare delle disdette per l'evento?(rispondere con 'si' o 'no')");
      String sceltaDisdette=scan.nextLine();
      if(sceltaDisdette.equalsIgnoreCase("si")){
        while(true){
          System.out.println("scegliere il numero di posti da disdire");
          try{
              int sceltaNumPosti=scan.nextInt();
              scan.nextLine();
              if(sceltaNumPosti>0){
                for(int i=0;i<sceltaNumPosti;i++){
                e1.disdici();
                
                }
              }else{
                System.out.println("scelta non valida");
              }
          }catch(InputMismatchException e){
            System.out.println("inserisci un numero vallido");
            scan.nextLine();
            continue;
          }  
          System.out.println("vuoi disdire altri posti? (rispondere con 'si' o 'no')");
          String sceltaDisdette2 = scan.nextLine();
          if (sceltaDisdette2.equalsIgnoreCase("no")) {
              break;
          }
        }
      }else{
        System.out.println("nessuna disdetta verrà effetuata");
      }
      System.out.println("il numero di posti totali del'evento sono "+e1.getNumeriPostiTotale()+", di cui disponibili "+e1.postiDisponibili());
    
      // creazione di istanze delle varie classi per testarne metodi e proprietà
      
      String dataConcerto="2026-07-07";
      String oraConcerto="21:30";
      LocalDate dataConc=LocalDate.parse(dataConcerto);
      LocalTime oraConc=LocalTime.parse(oraConcerto);

      Concerto c1=new Concerto("Metallica", dataConc, 500,oraConc, 200.5);
  
      System.out.println(c1);

      Evento e2 = new Evento("gioco",LocalDate.parse("2027-08-08"),400);
      Evento e3 = new Evento("fanta",LocalDate.parse("2027-08-08"),400);
      Evento e4 = new Evento("carlo",LocalDate.parse("2026-06-06"),400);
      Evento e5 = new Evento("cinema",LocalDate.parse("2035-08-08"),400);
      Evento e6 = new Concerto("zuccchero",LocalDate.parse("2033-09-09"),5000,LocalTime.parse("22:45"),100.99);

      ProgrammaEventi ListaEventi = new ProgrammaEventi("Eventi prossimi anni");
      ListaEventi.aggiungiEvento(e1);
      ListaEventi.aggiungiEvento(e2);
      ListaEventi.aggiungiEvento(e3);
      ListaEventi.aggiungiEvento(e4);
      ListaEventi.aggiungiEvento(e5);
      ListaEventi.aggiungiEvento(e6);
      ListaEventi.aggiungiEvento(c1);
      System.out.println("gli eventi in totale sono "+ListaEventi.dimensioniLista());
      System.out.println("gli eventi in data 08/08/2027 sono "+ProgrammaEventi.listaFiltroData(ListaEventi.getEventi(),LocalDate.parse("2027-08-08")));
      System.out.println("gli eventi in progrmma nei prossimi anni sono "+ProgrammaEventi.listaFormattata(ListaEventi.getEventi()));


    }

    

}