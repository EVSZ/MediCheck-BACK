package medicheck.backend.Logic.Models.medicine;

import medicheck.backend.DAL.Interfaces.IMedicationContainer;
import medicheck.backend.DTO.MedicineDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineContainer {

    private List<Medicine> medication = new ArrayList<>();
    IMedicationContainer Interface;

    public MedicineContainer(IMedicationContainer Inter)
    {
        Interface = Inter;
    }

    public Medicine GetByName(String naam){
        for (Medicine medicine:
             medication) {
            if(medicine.getName().equals(naam)){
                return medicine;
            }
        }
        throw new ArithmeticException("Dit medicijn staat niet in de lijst!");
    }
    public Medicine GetByID(long id){
        for (Medicine medicine:
                medication) {
            if(medicine.getId().equals(id)){
                return medicine;
            }
        }
        throw new ArithmeticException("Dit medicijn staat niet in de lijst!");
    }

    public List<Medicine> GetAllMedicines()
    {
        List<MedicineDTO> MedicinesDTO = Interface.GetAllMedication();
        List<Medicine> Medicines = new ArrayList<Medicine>();
        for (MedicineDTO Medicine: MedicinesDTO)
        {
            Medicines.add(new Medicine(Medicine));
        }
        return Medicines;
    }

    public List<Medicine> GetAllMedicineByType(MedicineType type){
        List<Medicine> output  = new ArrayList<>();
        for (Medicine medicine:
             medication) {
            if(medicine.getMedicineType() == type) output.add(medicine);
        }
        return output;
    }

    public void MockMedicines(){
        List<Medicine> mockMedication = new ArrayList<>();

        Medicine paracetemol = new Medicine("Niet voor de lol, paracetemol.", "Paracetemol", MedicineType.Pillen);
        Medicine hoestsiroop = new Medicine("It's only to cope, hoestsiroop", "Hoestdrank", MedicineType.Siroop);
        Medicine ibuprofen = new Medicine("Iets met een pen, ibuprofen", "Ibuprofen", MedicineType.Pillen);

        mockMedication.add(paracetemol);
        mockMedication.add(hoestsiroop);
        mockMedication.add(ibuprofen);

        medication = mockMedication;
    }
}
