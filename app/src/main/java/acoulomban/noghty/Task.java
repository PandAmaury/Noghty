package acoulomban.noghty;

/**
 * Created by acoulomban on 03/05/15.
 */
public class Task {
    private int id;
    private String label;
    private String state;
    private int parentTask;
    private String description;

    public Task() {

    }

    public Task(String label, String state, int parentTask, String description) {
        this.label = label;
        this.state = state;
        this.parentTask = parentTask;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getParentTask() {
        return parentTask;
    }

    public void setParentTask(int parentTask) {
        this.parentTask = parentTask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
