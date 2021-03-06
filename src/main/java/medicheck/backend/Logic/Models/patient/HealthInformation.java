package medicheck.backend.Logic.Models.patient;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.HealthInformationDTO;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable @Getter @Setter
public class HealthInformation {


    public int clcr;
    public LocalDate lastclcr;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;

    public HealthInformation() {

    }

    public HealthInformation(HealthInformationDTO healthInfo)
    {
        this.clcr = healthInfo.getClcr();
        this.lastclcr = healthInfo.getLastclcr();
        this.weight = healthInfo.getWeight();
        this.length = healthInfo.getLength();
        this.pregnant = healthInfo.getPregnant();
    }
}
