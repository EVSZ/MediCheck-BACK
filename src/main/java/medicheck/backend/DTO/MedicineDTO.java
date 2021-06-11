package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineType;

@Getter @Setter
public class    MedicineDTO
{
    private long id;
    private boolean hasRule;
    private Long ruleID;
    private String name;
    private String Discription;
    private MedicineType medicineType;

    public MedicineDTO(Integer id, String discription, String name, MedicineType medicineType)
    {
        this.id = id;
        this.name = name;
        this.Discription = discription;
        this.medicineType = medicineType;;
    }
    public MedicineDTO(Medicine medicine)
    {
        this.id = medicine.getId();
        this.name = medicine.getName();
        this.Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }
    public MedicineDTO(MedicineDataModel medicine)
    {
        this.id = medicine.getId();
        this.hasRule = medicine.isHasRule();
        this.ruleID = medicine.getRuleID();
        this.name = medicine.getName();
        this.Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }
}
