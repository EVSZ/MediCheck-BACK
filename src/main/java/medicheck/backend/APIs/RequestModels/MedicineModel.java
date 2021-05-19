package medicheck.backend.APIs.RequestModels;
import lombok.*;
import medicheck.backend.Logic.Models.medicine.MedicineType;

@Getter @Setter
public class MedicineModel
{
    private String discription;
    private boolean hasRule;
    private Long id;
    private MedicineType medicineType;
    private String name;
    private Long ruleID;
}
