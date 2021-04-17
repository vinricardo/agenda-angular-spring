package ricardo.vinicius.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import ricardo.vinicius.agenda.model.Evento;
import ricardo.vinicius.agenda.repository.AgendaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class AgendaApplication {


	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
