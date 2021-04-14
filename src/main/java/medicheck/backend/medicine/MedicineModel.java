package medicheck.backend.medicine;
import lombok.*;

@Getter @Setter
public class MedicineModel
{
    private Long id;
    private String name;
    private String Discription;
    private MedicineType medicineType;
}
