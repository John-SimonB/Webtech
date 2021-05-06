package htw.berlin.WebtechProjekt.Models;

public class ToDoList {

    private final String id;
    private final String task;
    private boolean status;


    public ToDoList(String id, String task, boolean status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    public String getId() {
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
