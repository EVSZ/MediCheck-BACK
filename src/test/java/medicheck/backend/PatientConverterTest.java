package medicheck.backend;

import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.Prescription.PrescriptionContainer;
import medicheck.backend.patient.Gender;
import medicheck.backend.patient.HealthInformation;
import medicheck.backend.patient.Patient;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class PatientConverterTest {

    @Mock
    PatientConverter patientConverter;

    @Before("")
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void patient_converter_succes() {
        patientConverter = new PatientConverter();
        HealthInformation hInfo = new HealthInformation();
        PrescriptionContainer pContainer = new PrescriptionContainer();
        Patient newP = new Patient(1, "Boy", 69, 420, true, LocalDate.now(), Gender.Male, hInfo, pContainer, 42);
        PatientDataModel pConverted = patientConverter.convertToDataModel(newP);

        Assertions.assertEquals(newP.getId(), pConverted.getId());
    }
}
