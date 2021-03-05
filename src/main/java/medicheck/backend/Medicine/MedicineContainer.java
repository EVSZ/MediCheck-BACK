package medicheck.backend.medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineContainer {

    private List<Medicine> medication = new ArrayList<>();

    public MedicineContainer() {
    }

    public Medicine GetByName(String naam){
        for (Medicine medicine:
             medication) {
            if(medicine.getName() == naam){
                return medicine;
            }
        }
        throw new ArithmeticException("Dit medicijn staat niet in de lijst!");
    }

    public List<Medicine> GetAllMedicines(){
        return medication;
    }

    public List<Medicine> GetAllMedicineByType(MedicineType type){
        List<Medicine> output  = new ArrayList<>();
        for (Medicine medicine:
             medication) {
            if(medicine.getMedicineType() == type) output.add(medicine);
        }
        return output;
    }

    public void AddMedicine(MedicineDTO mediceneDTO){

    }
}
