package pl.put.poznan.transformer.logic;

import java.util.List;
// Scenario.java
public class Scenario {

    private String name;
    private List<Step> steps;

    private List<Scenario> subScenarios;



    public Scenario() {

    }

    public Scenario(String name, List<Step> steps) {
        this.name = name;
        this.steps = steps;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Scenario{" +
                "name='" + name + '\'' +
                ", steps=" + steps +
                '}';
    }

    public List<Scenario> getSubScenarios() {
        return subScenarios;
    }

    public void setSubScenarios(List<Scenario> subScenarios) {
        this.subScenarios = subScenarios;
    }
}
