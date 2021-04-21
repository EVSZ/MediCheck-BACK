package medicheck.backend.patient;

import javax.persistence.Embeddable;

@Embeddable
public class HealthInformation {

    public int clcr = 0;
    public int monthsSinceLastclcr=0;
    public int worst;

    public HealthInformation() {

    }
}
