package medicheck.backend.DAL.ListConverters;

import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DTO.MedicineDTO;

import java.util.ArrayList;
import java.util.List;

public class MedicineDataModelListTOMedicineDTOList
{
    public List<MedicineDTO> ConvertListMedicineToListMedicineDTO(List<MedicineDataModel> MedicinesData)
    {
        List<MedicineDTO> MedicineDTOs = new ArrayList<MedicineDTO>();
        for(MedicineDataModel medicine: MedicinesData)
        {
            MedicineDTOs.add(new MedicineDTO(medicine));
        }
        return MedicineDTOs;
    }
}
