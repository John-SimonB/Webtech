package htw.berlin.WebtechProjekt.Models;

import javax.persistence.*;

@Entity
//@Table(name = " ") <- Tabellenname ändern
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id wird generiert
    private long id; //final musste weg & 'String' zu 'long' geändert

    @Column (nullable = false)//Sagt an: ist eine Spalte in Tabelle, Wert darf nicht null sein
    private String task;

    @Column //(name = " ") <- Name der Spalte kann so hinzugefügt werden
    private boolean status;


    public ToDoListEntity(long id, String task, boolean status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    protected ToDoListEntity(){} //Konstruktor

    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
