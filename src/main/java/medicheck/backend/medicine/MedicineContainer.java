package medicheck.backend.medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineContainer {

    private List<Medicine> medicines = new ArrayList<>();

    public MedicineContainer() {
    }

    public Medicine GetByName(String naam){
        for (Medicine medicine:
             medicines) {
            if(medicine.getNaam() == naam){
                return medicine;
            }
        }
        throw new ArithmeticException("Dit medicijn staat niet in de lijst!");
    }

    public List<Medicine> GetAllMedicines(){
        return medicines;
    }

    public List<Medicine> GetAllMedicineByType(MedicineType type){
        List<Medicine> output  = new ArrayList<>();
        for (Medicine medicine:
             medicines) {
            if(medicine.getMedicineType() == type) output.add(medicine);
        }
        return output;
    }

    public void AddMedicine(MedicineDTO mediceneDTO){

    }
}
