package medicheck.backend.Prescription;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionContainer
{
    List<Prescription> Recepten = new ArrayList<>();

    public Prescription GetReceptById(int id){
        for (Prescription prescription :
                Recepten) {
            if(prescription.getReceptId() == id) return prescription;
        }
        throw new ArithmeticException("Recept niet gevonden!");
    }

    public List<Prescription> GetReceptByUserID(int id)
    {
        return Recepten;
    }
}
