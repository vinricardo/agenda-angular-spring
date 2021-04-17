import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import  interactionPlugin  from '@fullcalendar/interaction';
import  dayGridPlugin  from '@fullcalendar/daygrid';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CalendarOptions } from '@fullcalendar/angular';
import { HttpClient } from '@angular/common/http';





@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  eventsAdded: any[] =  [];
  dateEvent: Date;
  titleEvent: String;
  calendarOptions: CalendarOptions = {
    plugins: [dayGridPlugin, interactionPlugin],

  };


  constructor( private http: HttpClient,){}



  addEvent(){
    const data = this.dateEvent.toJSON().split("T");
    const eventName : any = this.titleEvent;
    const event: any = {
      "color": "#1a1a1a",
      "title": eventName,
      "start": data[0]
    }

    this.eventsAdded.push(event)

    // this.calendarOptions.events = this.eventsAdded;
    this.dateEvent = null;
    this.titleEvent = null;
    console.log(event)
    this.http.post("http://localhost:8080/agenda/eventos",event).subscribe( d => console.log(d));
    this.http.get("http://localhost:8080/agenda/eventos").subscribe( d => this.calendarOptions.events = d);
  }




  ngOnInit(){
    this.http.get("http://localhost:8080/agenda/eventos").subscribe( d => this.calendarOptions.events = d);
  }
}
