package Eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int numeroPostiTotale;
    private int numeroPostiPrenotati =0;

    public Evento(String titolo, LocalDate data, int numeroPostiTotale){
        this.titolo=titolo;
        this.numeroPostiTotale=numeroPostiTotale;
        LocalDate oggi = LocalDate.now();

        if(data.isBefore(oggi)){
            throw new IllegalArgumentException("la data non dev'essere precedente a quella odierna");
        }
        else{
            this.data=data;
        }
        
        if(numeroPostiTotale<=0){
            throw new IllegalArgumentException("inserire un numero maggiore di 0");
        }
        else{
            this.numeroPostiTotale=numeroPostiTotale;
        }
    }

    public void setTitolo(String titolo){
        this.titolo=titolo;
    }

    public String getTitolo(){
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getNumeriPostiTotale(){
        return numeroPostiTotale;
    }

    public int getNumeriPostiPrenotati(){
        return numeroPostiPrenotati;
    }

    public void prenota(){
        if(data.isBefore(LocalDate.now())||numeroPostiPrenotati==numeroPostiTotale){
            throw new IllegalArgumentException("impossibile prenotare posti per quest'evento");
           
        }
        else{
            numeroPostiPrenotati+=1;
        }
    }

    public void disdici(){
        if (data.isBefore(LocalDate.now())||numeroPostiPrenotati==0){
             throw new IllegalArgumentException("impossibile disdire posti per l'evento");
    
        }
        else {
            numeroPostiPrenotati-=1;
        }
    }

    public int postiDisponibili(){
        return numeroPostiTotale-numeroPostiPrenotati;
    }

    
    @Override
    public String toString() {
        DateTimeFormatter form=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata=data.format(form);
        return dataFormattata+" - "+titolo;
    }

   

}
