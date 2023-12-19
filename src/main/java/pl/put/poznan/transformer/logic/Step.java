// Step.java
package pl.put.poznan.transformer.logic;
public class Step {

    private String action;
    private String description;


    public Step() {

    }

    public Step(String action, String description) {
        this.action = action;
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Step{" +
                "action='" + action + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
