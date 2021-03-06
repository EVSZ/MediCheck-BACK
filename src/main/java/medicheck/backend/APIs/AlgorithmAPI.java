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

    @PostMapping(value = "/getAdvice/{id}", produces = "application/json")
    public boolean GetAdvice(@PathVariable int id )
    {
        int worst = id;
        return adviceGenerator.GenerateAdvice(id);
        //return adviceGenerator.GenerateAdvice(41);

    }

    @GetMapping()
    MedicationListInfo GetMedicationList(MedicationListInfo info) {
        return info;
    }

}
