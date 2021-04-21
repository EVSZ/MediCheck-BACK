package medicheck.backend;

import medicheck.backend.medicine.Medicine;
import medicheck.backend.medicine.MedicineContainer;
import medicheck.backend.medicine.MedicineType;
import medicheck.backend.medicine.SideEffect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
class MedicationContainerTest {

    @Mock
    MedicineContainer medicontainer;

    @Before("")
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void return_patient_by_id_correctly() {
        List<SideEffect> effects = new ArrayList<>();
        //Medicine medic = new Medicine(7, 5, "K", MedicineType.Pillen, effects, 5, LocalDate.now());
        //Mockito.when(medicontainer.GetByID(7)).thenReturn(medic);
        //Medicine result = medicontainer.GetByID(7);
        //Assertions.assertEquals(medic, result);
    }
    @Test
    public void return_patient_by_id_false() {
        List<SideEffect> effects = new ArrayList<>();
        //Medicine medic = new Medicine(10, 5, "K", MedicineType.Pillen, effects, 5, LocalDate.now());
        //Mockito.when(medicontainer.GetByID(10)).thenReturn(medic);
        //Medicine result = medicontainer.GetByID(7);
        //Assertions.assertNotEquals(medic, result);
    }
    @Test
    public void return_patient_does_not_exist() {
        Assertions.assertNull(medicontainer.GetByID(7));
    }
}
