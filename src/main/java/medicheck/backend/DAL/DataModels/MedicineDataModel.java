package medicheck.backend.DAL.DataModels;

import lombok.Setter;
import medicheck.backend.DTO.MedicineDTO;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineType;

import javax.persistence.*;

import lombok.Getter;

@Entity  @Getter @Setter
public class MedicineDataModel
{
    @Id
    @GeneratedValue
    private Long id;
    private String Name;
    private boolean hasRule;
    private Long ruleID;
    private String Discription;

    @Enumerated(EnumType.ORDINAL)
    private MedicineType medicineType;

    public MedicineDataModel() { }
    public MedicineDataModel(MedicineDTO medicine)
    {
        this.id = medicine.getId();
        this.Discription = medicine.getDiscription();
        this.Name = medicine.getName();
        this.medicineType = medicine.getMedicineType();
    }
}
