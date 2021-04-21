package medicheck.backend.medicine;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineContainer {

    private final List<Medicine> medication = new ArrayList<>();

    public MedicineContainer() { }

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
}
