package medicheck.backend.patiënt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PatiëntContainer {

    private List<Patiënt> patiënten = new ArrayList<>();

    public PatiëntContainer() {
    }

    public Patiënt GetPatiëntByNaam(String naam){
        for (Patiënt patiënt:
             patiënten) {
            if(patiënt.getNaam() == naam) return patiënt;
        }
        throw new ArithmeticException("De patiënt is niet gevonden!");
    }

    public Patiënt GetPatiëntBtID(Integer id){
        for (Patiënt patiënt:
             patiënten) {
            if(patiënt.getId() == id) return patiënt;
        }
        throw new ArithmeticException("De patiënt is niet gevonden!");
    }

    public void SavePatiënt(Patiënt patiënt){
        patiënten.add(patiënt);
    }
}
