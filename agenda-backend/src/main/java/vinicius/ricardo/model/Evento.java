package vinicius.ricardo.model;

public class Evento {
   private String color;
   private String title;
   private String start;

    public  Evento(){
        super();
    }

    public Evento(String color, String title, String start) {
        this.color = color;
        this.title = title;
        this.start = start;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }


}
