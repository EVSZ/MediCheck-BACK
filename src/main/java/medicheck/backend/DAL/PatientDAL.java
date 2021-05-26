package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.Interfaces.IAuthentication;
import medicheck.backend.DAL.Interfaces.IPatientContainer;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDAL implements IPatientContainer, IPatient, IAuthentication
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MediCheck-BACK");
    EntityTransaction transaction;
    EntityManager manager  = factory.createEntityManager();

    public PatientDTO GetInlogPatient(String Username, String Password)
    {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientDataModel> query = builder.createQuery(PatientDataModel.class);
        Root<PatientDataModel> root = query.from(PatientDataModel.class);
        query.select(root)
                .where(builder.like(root.get("Username"), Username))
                .where(builder.like(root.get("Password"), Password));

        try
        {
            return new PatientDTO(manager.createQuery(query).getSingleResult());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
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

    public PatientDTO GetPatient(long patientID)
    {
        String query = "SELECT patient FROM PatientDataModel patient WHERE patient.id = :id";

        TypedQuery<PatientDataModel> tq = manager.createQuery(query, PatientDataModel.class);
        tq.setParameter("id",patientID);

        try
        {
            return new PatientDTO(tq.getSingleResult());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
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

    public void SavePatient(PatientDTO patientDTO)
    {
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new PatientDataModel(patientDTO));
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

    public void RegisterPatient(AccountDTO patientDTO)
    {
        try
        {
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new PatientDataModel(patientDTO));
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

    public void DeletePatient(PatientDTO patientDTO)
    {
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(new PatientDataModel(patientDTO));
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
