package medicheck.backend.APIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("algorithm")
public class AlgorithmAPI {

    @GetMapping("/execute")
    public String executeAlgorithm(){
        return "Not implemented yet!";
    }
}
