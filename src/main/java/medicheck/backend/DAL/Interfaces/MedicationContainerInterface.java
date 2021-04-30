package medicheck.backend.DAL.Interfaces;

import medicheck.backend.DTO.MedicineDTO;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface MedicationContainerInterface
{
    @Bean
    public List<MedicineDTO> GetAllMedication();
}
