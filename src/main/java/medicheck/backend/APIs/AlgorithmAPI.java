package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.APIs.RequestModels.MedicationListInfo;
import medicheck.backend.APIs.RequestModels.AccessData;
import medicheck.backend.Algoritmiek.AdviceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Scope(value = "session")
public class AlgorithmAPI {

    private final AdviceGenerator adviceGenerator;
    @Autowired
    private AccessData accessData;

    @ModelAttribute("accesData")
    public AccessData getAccesData() {
        return this.accessData;
    }



    public AlgorithmAPI(AdviceGenerator adviceGenerator) {
        this.adviceGenerator = adviceGenerator;
    }

    @GetMapping(value = "/getAdvice", produces = "application/json")
    public boolean GetAdvice()
    {
        long ding = accessData.getUserID();
        return adviceGenerator.GenerateAdvice(ding);
        //return adviceGenerator.GenerateAdvice(41);

    }

    @GetMapping()
    MedicationListInfo GetMedicationList(MedicationListInfo info) {
        return info;
    }

}
