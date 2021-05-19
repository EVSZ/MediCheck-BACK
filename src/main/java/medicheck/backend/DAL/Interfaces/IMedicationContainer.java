package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DTO.MedicineDTO;

import java.util.List;

public interface IMedicationContainer
{
    public List<MedicineDTO> GetAllMedication();
}
