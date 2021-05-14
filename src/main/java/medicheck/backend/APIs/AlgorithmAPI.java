package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.APIs.RequestModels.MedicineModel;
import medicheck.backend.Algoritmiek.AdviceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    @Autowired
    public AlgorithmAPI() {}

    @PostMapping("/getAdvice")
    public boolean GetAdvise(@RequestBody MedicineModel[] medicineModels)
    {
        AdviceGenerator adviceGenerator = new AdviceGenerator();

        return true;
    }

}
