package medicheck.backend.Converters;

import medicheck.backend.DataModels.MedicineDataModel;
import medicheck.backend.medicine.Medicine;

public class MedicineConverter
{
    public MedicineConverter() {
    }

    public MedicineDataModel convertToDataModel(Medicine medicine)
    {
        MedicineDataModel medicineDataModel = new MedicineDataModel();
        medicineDataModel.setId(medicine.getId());
        medicineDataModel.setName(medicine.getName());
        medicineDataModel.setDiscription(medicine.getDiscription());
        medicineDataModel.setMedicineType(medicine.getMedicineType());
        return medicineDataModel;
    }

}
