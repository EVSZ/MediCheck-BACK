package medicheck.backend.Prescription;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PrescriptionContainer
{
    List<Prescription> Prescriptions = new ArrayList<>();

    public Prescription GetPrescriptionById(long id){
        for (Prescription prescription :
                Prescriptions) {
            if(prescription.getId() == id) return prescription;
        }
        throw new ArithmeticException("Recept niet gevonden!");
    }

    public List<Prescription> GetPrescriptionByMedicineID(long MedicineID)
    {
        List<Prescription> FilteredList = new ArrayList<>();
        for (Prescription prescription : Prescriptions)
        {
            if(prescription.getId() == MedicineID)
            {
                FilteredList.add(prescription);
            }
        }
        return FilteredList;
    }
    public List<Prescription> GetPrescriptionByPatientID(long PatientID)
    {
        List<Prescription> FilteredList = new ArrayList<>();
        for (Prescription prescription : Prescriptions)
        {
            if(prescription.getId() == PatientID)
            {
                FilteredList.add(prescription);
            }
        }
        return FilteredList;
    }

    public List<Prescription> GetPrescriptions()
    {
        return Prescriptions;
    }
}