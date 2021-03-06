package medicheck.backend.Logic.Models.medicine;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.MedicineModel;
import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DTO.MedicineDTO;

@Getter @Setter
public class Medicine
{
    private String Discription;
    private boolean hasRule;
    private Long id;
    private MedicineType medicineType;
    private String name;
    private Long ruleID;
    //private MedicineConverter converter = new MedicineConverter();

    public Medicine(){}
    public Medicine( boolean hasRule,Long id,MedicineType medicineType,String name, Long ruleID, String discription)
    {
        this.id = id;
        this.ruleID = ruleID;
        this.hasRule = hasRule;
        this.name = name;
        Discription = discription;
        this.medicineType = medicineType;
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
        this.Discription = medicine.getDiscription();
        this.medicineType = medicine.getMedicineType();
    }
}
