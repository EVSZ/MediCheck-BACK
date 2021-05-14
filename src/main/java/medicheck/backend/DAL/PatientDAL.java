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
        String query = "SELECT patient FROM PatientDataModel patient WHERE patient.Username = :username AND patient.Password = :password";

        TypedQuery<PatientDataModel> tq = manager.createQuery(query, PatientDataModel.class);
        tq.setParameter("username",Username);
        tq.setParameter("password",Password);

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
