package medicheck.backend.DAL;

import medicheck.backend.Algoritmiek.AlgorithmRepo;
import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.Algoritmiek.Interface.SubRuleContainerInterface;
import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DAL.Interfaces.MedicationContainerInterface;
import medicheck.backend.DAL.Interfaces.MedicationInterface;
import medicheck.backend.DAL.Repos.MedicineRepo;
import medicheck.backend.DTO.MedicineDTO;
import medicheck.backend.DTO.SubRuleDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicineDAL implements MedicationContainerInterface, MedicationInterface
{
    MedicineRepo repo;

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
