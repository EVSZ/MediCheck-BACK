package medicheck.backend.APIs;

import medicheck.backend.patiënt.Patiënt;
import medicheck.backend.patiënt.PatiëntContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patiënten")
public class PatiëntController {

    private PatiëntContainer patiënten;

    @Autowired
    public PatiëntController(PatiëntContainer container){
        this.patiënten = container;
    }

    @PostMapping("/post")
    public void AddPatiënt(@RequestBody Patiënt patiënt){
        patiënten.SavePatiënt(patiënt);
    }

    /*@GetMapping("/get/{id}")
    public Patiënt GetPatiënt(Integer id){
        return patiënten.GetPatiëntBtID(id);
    }*/
    @GetMapping("/get")
    public Patiënt GetPatiënt(){
        return new Patiënt(1);
    }
}
