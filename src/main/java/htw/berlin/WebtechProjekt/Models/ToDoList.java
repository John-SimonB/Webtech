package htw.berlin.WebtechProjekt.Models;

public class ToDoList {

    private final long id;
    private final String task;
    private Status state;


    public ToDoList(long id, String task, Status state) {
        this.id = id;
        this.task = task;
        this.state = state;
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

    public void setStatus(Status state) {
        this.state = state;
    }
}
