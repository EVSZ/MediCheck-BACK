package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.APIs.RequestModels.MedicationListInfo;
import medicheck.backend.APIs.RequestModels.MedicineModel;
import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.Logic.Models.medicine.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    private final AdviceGenerator adviceGenerator;

    public AlgorithmAPI(AdviceGenerator adviceGenerator) {
        this.adviceGenerator = adviceGenerator;
    }

    @PostMapping(value = "/getAdvice", consumes = "application/json", produces = "application/json")
    public boolean GetAdvice(@RequestBody List<MedicineModel> info, HttpServletRequest request)
    {
        List<Medicine> medicines = new ArrayList<Medicine>();
        for (MedicineModel medicineModel:
                info) {
            Medicine medicine = new Medicine(
                    medicineModel.getId(),
                    medicineModel.isHasRule(),
                    medicineModel.getRuleID(),
                    medicineModel.getDiscription(),
                    medicineModel.getName(),
                    medicineModel.getMedicineType()
            );
            medicines.add(medicine);
        }
        return adviceGenerator.GenerateAdvice((int)request.getSession().getAttribute("patientId"));
    }

    @GetMapping()
    MedicationListInfo GetMedicationList(MedicationListInfo info) {
        return info;
    }

}
