package com.controllers;

import com.model.AutoData;
import com.model.Customer;
import com.model.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {

    // Method To Fetch All School Details From The Database
    @SuppressWarnings("unchecked")
    public static List<Customer> getCustomersList() {
        Configuration con =  new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customerList = new ArrayList<Customer>();
        try{
            Query queryObj = session.createQuery("SELECT c FROM Customer c");
            customerList = queryObj.getResultList();
        }
        catch (Exception ex){}
        finally {
            transaction.commit();
            session.close();
            sf.close();
        }
        if (customerList != null && customerList.size() > 0) {
            return customerList;
        } else {
            return null;
        }
    }
    @SuppressWarnings("unchecked")
    public static boolean deleteCustomer(Customer customer){
        boolean response;
        Configuration con =  new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(customer);
            response = true;
        }
        catch (Exception ex)
        {
            response = false;
        }
        finally {
            transaction.commit();
            session.close();
            sf.close();
        }
        return response;
    }

    @SuppressWarnings("unchecked")
    public static boolean saveCustomer(Customer customer, AutoData autoData, Profile profile){
        boolean response;
        Configuration con =  new Configuration().configure();
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            if(customer.getId() == null) {
                session.save(customer);
                autoData.setCustomer(customer);
                profile.setCustomer(customer);

                customer.setAutodata(autoData);
                customer.setProfile(profile);
                session.update(customer);
            }
            else {
                session.update(customer);
            }
            KieServices kService=KieServices.Factory.get();
            KieContainer kContainer=kService.getKieClasspathContainer();
            KieSession kieSession=kContainer.newKieSession("ksession-rules");

            kieSession.insert(customer);
            kieSession.insert(autoData);
            kieSession.insert(profile);
            kieSession.fireAllRules();

            kieSession.destroy();

            session.update(customer);

            response = true;
        }
        catch (Exception ex)
        {
            response = false;
        }
        finally {
            transaction.commit();
            session.close();
            sf.close();
        }
        return response;
    }
}
