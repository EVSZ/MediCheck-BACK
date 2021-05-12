package medicheck.backend.Logic.Models.patient;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable @Getter @Setter
public class HealthInformation {

    public int clcr = 0;
    public LocalDate lastclcr;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;

    public HealthInformation() {

    }
}
