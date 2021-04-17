package ricardo.vinicius.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ricardo.vinicius.agenda.SendEmailService;
import ricardo.vinicius.agenda.model.Evento;
import ricardo.vinicius.agenda.repository.AgendaRepository;

import java.util.ArrayList;

@RestController
public class AgendaController {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private SendEmailService sendEmailService;

    @GetMapping(value="/agenda/eventos")
    public ArrayList<Evento> getEventos(){
        return agendaRepository.getEvents();
    }

    @PostMapping(value = "/agenda/eventos")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Evento setEvent(@RequestBody Evento event){
        agendaRepository.save(event);
        sendEmailService.sendEmail(
                "pagenda.2021@gmail.com",
                "Olá, seu evento acaba de ser adicionado no calendário",
                "Evento chamado de: " + event.getTitle());
        return event;
    }
}
