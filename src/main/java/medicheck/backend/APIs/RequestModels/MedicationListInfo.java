package medicheck.backend.APIs.RequestModels;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Logic.Models.medicine.Medicine;

import java.util.List;

@Getter @Setter
public class MedicationListInfo
{
    List<MedicineModel> Medicines;
}
