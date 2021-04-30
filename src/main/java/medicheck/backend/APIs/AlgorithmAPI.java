package medicheck.backend.APIs;

//import medicheck.backend.Algoritmiek.AdviceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    @Autowired
    public AlgorithmAPI() {}

    @GetMapping("/getAdvice")
    public String GetAdvise()
    {
        /*AdviceGenerator adviceGenerator = new AdviceGenerator();

        return adviceGenerator.GetAdvice(patient);*/
        return "Request recieved";
    }

}
