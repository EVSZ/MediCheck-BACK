package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.MedicineDataModel;
import medicheck.backend.DAL.Interfaces.IMedicationContainer;
import medicheck.backend.DAL.Interfaces.IMedication;
import medicheck.backend.DAL.ListConverters.MedicineDataModelListTOMedicineDTOList;
import medicheck.backend.DAL.Repos.MedicineRepo;
import medicheck.backend.DTO.MedicineDTO;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MedicineDAL implements IMedicationContainer, IMedication
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MediCheck-BACK");
    EntityTransaction transaction;
    EntityManager manager  = factory.createEntityManager();

    public List<MedicineDTO> GetAllMedication()
    {
        manager = factory.createEntityManager();
        String strQuery = "SELECT medicine FROM MedicineDataModel medicine WHERE medicine.id IS NOT NULL";
        MedicineDataModelListTOMedicineDTOList converter = new MedicineDataModelListTOMedicineDTOList();

        TypedQuery<MedicineDataModel> tq = manager.createQuery(strQuery, MedicineDataModel.class);

        try
        {
            return converter.ConvertListMedicineToListMedicineDTO(tq.getResultList());
        }
        catch (Exception ex)
        {
            return null;
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
        }
    }
    public void SaveMedicine(MedicineDTO medicineDTO)
    {
        manager = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new MedicineDataModel(medicineDTO));
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }
    public void DeleteMedicine(MedicineDTO medicineDTO)
    {
        manager = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(new MedicineDataModel(medicineDTO));
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }
}
