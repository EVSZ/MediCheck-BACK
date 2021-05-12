package medicheck.backend.Logic.Models.patient;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class HealthInformation {

    public int clcr = 0;
    public LocalDate lastclcr;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;

    public HealthInformation() {

    }
}
