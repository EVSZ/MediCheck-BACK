package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.MedicineDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface MedicationInterface
{
    public void SaveMedicine(MedicineDTO medicineDTO);
    public void DeleteMedicine(MedicineDTO medicineDTO);
}
