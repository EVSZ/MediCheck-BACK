package medicheck.backend.Prescription;
import java.util.ArrayList;
import java.util.List;
public class PrescriptionContainer {
    List<Prescription> recepten = new ArrayList<>();

    public Prescription GetReceptbyId(int id){
        for (Prescription prescription :
             recepten) {
            if(prescription.getReceptId() == id) return prescription;
        }
        throw new ArithmeticException("Recept niet gevonden!");
    }

    public List<Prescription> GetRecepten(){
        return recepten;
    }
}
