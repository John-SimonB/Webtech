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

    @Column (name ="Status")
    @Enumerated(value = EnumType.STRING)
    private Status state;

    @Column (name ="Deadline")
    private LocalDate deadline;

    public ToDoListEntity(String task, Status state, LocalDate deadline) {
        this.task = task;
        this.state = state;
        this.deadline = deadline;
    }

    protected ToDoListEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Status isStatus() {
        return state;
    }

    public LocalDate getDeadline() {
        return deadline;
    }
}