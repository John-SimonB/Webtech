package htw.berlin.WebtechProjekt.Models;

import javax.persistence.*;

@Entity
@Table(name = "ToDo")
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id wird generiert
    private Long id;

    @Column (nullable = false) // Wert darf nicht null sein
    private String task;

    @Column (name ="Status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status state;

    public ToDoListEntity(String task, Status status) {
        this.task = task;
        this.state = state;
    }

    protected ToDoListEntity() {
    }

    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public Status isStatus() {
        return state;
    }

}
