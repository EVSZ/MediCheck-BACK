package medicheck.backend.APIs;

import medicheck.backend.medicine.MedicineContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medication")
public class MedicationAPI {

    @PostMapping(value = "/save", consumes )
    public void saveMedication(){

    }

    public MedicineContainer GetMedicine(){

    }

    public void RemoveMedicine(){

    }
}
