package medicheck.backend.Logic.Models.patient;

import javax.persistence.Embeddable;

@Embeddable
public class HealthInformation {

    public int clcr = 0;
    public int monthsSinceLastclcr=0;
    public int worst;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;

    public HealthInformation() {

    }
}
