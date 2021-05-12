package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
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

    @GetMapping("/getAdvice")
    public String GetAdvice()
    {

        //return adviceGenerator.GenerateAdvice();
        return "Request recieved";
    }

}
