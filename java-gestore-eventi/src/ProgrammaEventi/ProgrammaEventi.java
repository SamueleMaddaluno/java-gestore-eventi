package ProgrammaEventi;

import Eventi.Evento;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {
    private String titolo;
    private List<Evento> eventi;


    public ProgrammaEventi(String titolo){
        this.titolo=titolo;
        this.eventi=new ArrayList<>();
    }

    public void aggiungiEvento(Evento evento){
        eventi.add(evento);
    }
    public void svuotaLista(){
        eventi.clear();
    }
    public int dimensioniLista(){
        return eventi.size();
    }
    public static List<Evento> listaFiltroData(List<Evento> lista,LocalDate data){
        List<Evento> finale=new ArrayList<>();
        for(Evento e : lista){
            if(e.getData().equals(data)){
                finale.add(e);
            }
        }
        return finale;
    }
    public static String listaFormattata(List<Evento> e){
        e.sort(Comparator.comparing(Evento::getData));
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");

       return  e.stream()
                .map(evento->evento.getData().format(formatter)+" - "+evento.getTitolo())
                .reduce("",(a,b) -> a+b+"\n");
    }

    public List<Evento> getEventi() {
        return eventi;
    }
    
    
}
