package vinicius.ricardo.repository;

import vinicius.ricardo.SendEmailService;
import vinicius.ricardo.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.ArrayList;


@Repository
public class AgendaRepository {

    private ArrayList<Evento> listEvents;
    LocalDateTime date;

    @Autowired
    private SendEmailService sendEmailService;


    public AgendaRepository() {
        listEvents = new ArrayList<>();
        listEvents.add(new Evento("#1a1a1a","teste1", "2021-04-21"));
        listEvents.add(new Evento("#1a1a1a", "teste2","2021-04-22"));
    }


    public ArrayList<Evento> getEvents(){
        verification();
        return this.listEvents;
    }

    public void verification(){
        date = LocalDateTime.now();

        for(Evento event : listEvents){
            int year = Integer.parseInt(event.getStart().split("-")[0]);
            int month = Integer.parseInt(event.getStart().split("-")[1]);
            int day = Integer.parseInt(event.getStart().split("-")[2]);
            if(date.getYear() == year  && date.getMonth().getValue() == month
                    && date.getDayOfMonth()+1 == day){
                sendEmailService.sendEmail("pagenda.2021@gmail.com",
                        "Olá, informamos que seu evento ocorrerá amanhã!",
                        "Sobre o evento: "+event.getTitle());
            }
        }
    }

    public void save(Evento event) {
        listEvents.add(event);
        verification();
    }
}
