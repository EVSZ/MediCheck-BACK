package medicheck.backend.Prescription;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionContainer
{
    List<Prescription> Prescriptions = new ArrayList<>();

    public Prescription GetPrescriptionById(int id){
        for (Prescription prescription :
                Prescriptions) {
            if(prescription.getId() == id) return prescription;
        }
        throw new ArithmeticException("Recept niet gevonden!");
    }

    public List<Prescription> GetPrescriptionByUserID(int Userid)
    {
        return Prescriptions;
    }
<<<<<<< Updated upstream
=======
    public List<Prescription> GetPrescriptions(){
        return Prescriptions;
    }
>>>>>>> Stashed changes
}
