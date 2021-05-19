package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.APIs.RequestModels.MedicationListInfo;
import medicheck.backend.Algoritmiek.AdviceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    private final AdviceGenerator adviceGenerator;

    public AlgorithmAPI(AdviceGenerator adviceGenerator) {
        this.adviceGenerator = adviceGenerator;
    }

    @PostMapping(value = "/postAdvice", consumes = "application/json", produces = "application/json")
    public boolean GetAdvice(@RequestBody MedicationListInfo info)
    {
        return adviceGenerator.GenerateAdvice(info.getMedicines(),15);
    }

}
