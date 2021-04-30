package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.MedicineDTO;

public interface MedicationInterface
{
    public void SaveMedicine(MedicineDTO medicineDTO);
    public void DeleteMedicine(MedicineDTO medicineDTO);
}
