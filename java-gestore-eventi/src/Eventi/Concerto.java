package Eventi;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
    private LocalTime ora;
    private double  prezzo;

    public Concerto(String titolo, LocalDate data, int numeriPostiTotale,LocalTime ora, double prezzo){
        super(titolo, data, numeriPostiTotale);
        this.ora=ora;
        this.prezzo=prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
     public String dataFormattata(){
        DateTimeFormatter dataFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getData().format(dataFormatter);
     }

     public String oraFormattata(){
        DateTimeFormatter oraFormatter=DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(oraFormatter);
     }

     @Override
     public String toString(){
        DecimalFormat dfPrezzo= new DecimalFormat("#,#00.00 €");
        return dataFormattata()+" "+oraFormattata()+" - "+getTitolo()+" - "+dfPrezzo.format(prezzo);
     }
    
}
