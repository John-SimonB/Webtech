package htw.berlin.WebtechProjekt.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ToDo")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id wird generiert
    private Long id;

    @Column (nullable = false) // Wert darf nicht null sein
    private String task;


    @Column (name ="Deadline", nullable = false)
    private LocalDate deadline;

    @Column
    private String owner = "";

    public ToDoListEntity(String task, LocalDate deadline, String owner) {
        this.task = task;
        this.deadline = deadline;
        this.owner = owner;
    }

    protected ToDoListEntity() {
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }


    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}