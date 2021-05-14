package medicheck.backend.DTO;

import lombok.Getter;
import medicheck.backend.Logic.Models.patient.HealthInformation;

import java.time.LocalDate;
@Getter
public class HealthInformationDTO
{
    public int clcr;
    public LocalDate lastclcr;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;

    public HealthInformationDTO(HealthInformation healthInfo)
    {
        this.clcr = healthInfo.getClcr();
        this.lastclcr = healthInfo.getLastclcr();
        this.weight = healthInfo.getWeight();
        this.length = healthInfo.getLength();
        this.pregnant = healthInfo.getPregnant();
    }
}
