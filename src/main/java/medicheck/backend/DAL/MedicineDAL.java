package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DAL.Interfaces.IMedicationContainer;
import medicheck.backend.DAL.Interfaces.IMedication;
import medicheck.backend.DAL.Repos.MedicineRepo;
import medicheck.backend.DTO.MedicineDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineDAL implements IMedicationContainer, IMedication
{
    MedicineRepo repo;

    public MedicineDAL(MedicineRepo Repo)
    {
        repo = Repo;
    }

    public List<MedicineDTO> GetAllMedication()
    {
        List<MedicineDataModel> MedicineDataModels = repo.findAll();
        List<MedicineDTO> MedicinesDTO = new ArrayList<MedicineDTO>();
        for (MedicineDataModel Medicine: MedicineDataModels)
        {
            MedicinesDTO.add(new MedicineDTO(Medicine));
        }
        return MedicinesDTO;
    }
    public void SaveMedicine(MedicineDTO medicineDTO)
    {
        repo.save(new MedicineDataModel(medicineDTO));
    }
    public void DeleteMedicine(MedicineDTO medicineDTO)
    {
        repo.delete(new MedicineDataModel(medicineDTO));
    }
}
