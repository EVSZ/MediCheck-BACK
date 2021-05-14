package medicheck.backend.Logic.Models.medicine;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.MedicineModel;
import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DTO.MedicineDTO;

@Getter @Setter
public class Medicine
{
    private Long id;
    private boolean hasRule;
    private Long ruleID;
    private String name;
    private String Discription;
    private MedicineType medicineType;
    //private MedicineConverter converter = new MedicineConverter();

    public Medicine(Long id, boolean HasRule, Long ruleID, String discription, String name, MedicineType medicineType)
    {
        this.id = id;
        this.ruleID = ruleID;
        hasRule = HasRule;
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
        this.ruleID = ruleID;
    }
    public Medicine(String discription, String name, MedicineType medicineType)
    {
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
    }

    public Medicine(MedicineModel medicine)
    {
        this.id = medicine.getId();
        this.hasRule = medicine.isHasRule();
        this.ruleID = medicine.getRuleID();
        this.name = medicine.getName();
        Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }

    public Medicine(MedicineDTO medicine)
    {
        this.id = medicine.getId();
        this.hasRule = medicine.isHasRule();
        this.ruleID = medicine.getRuleID();
        this.name = medicine.getName();
        Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }
}
