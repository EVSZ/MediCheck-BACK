package medicheck.backend.APIs.RequestModels;
import lombok.*;
import medicheck.backend.Logic.Models.medicine.MedicineType;

@Getter @Setter
public class MedicineModel
{
    private Long id;
    private String name;
    private String Discription;
    private MedicineType medicineType;
    private boolean hasRule;
    private Long ruleID;
}
