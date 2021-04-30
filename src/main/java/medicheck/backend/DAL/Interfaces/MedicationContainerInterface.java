package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.MedicineDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MedicationContainerInterface
{
    public List<MedicineDTO> GetAllMedication();
}
