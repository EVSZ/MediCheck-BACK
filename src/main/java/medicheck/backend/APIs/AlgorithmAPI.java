package medicheck.backend.APIs;

import medicheck.backend.Algoritmiek.TestRule;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    @GetMapping("/execute")
    public String executeAlgorithm(){
        TestRule test = new TestRule();
        if (test.Test())
        {
            return "Test passed";
        };
        return "Test kapot";
    }


}
