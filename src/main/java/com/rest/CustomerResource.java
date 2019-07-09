package com.rest;

import com.model.Customer;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;
import java.util.List;


@Stateless
@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource{
    @PersistenceContext
    private Session entityManager;
//    @Inject
//    @KSession
//    private KieSession kieSession;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> listCustomers(){
        Query query = entityManager.createQuery("SELECT c FROM Customer c",Customer.class);

        return query.getResultList();
    }

    @GET
    @Path("{id}")
    public Customer getCustomer(@PathParam("id")BigInteger id){
        return entityManager.find(Customer.class,id);
    }

    @GET
    @Path("/auth")
    public Customer auth(@QueryParam("username")String username,
                         @QueryParam("password") String pass){
        Query   query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :pass",Customer.class);
                query.setParameter("username",username);
                query.setParameter("pass",pass);

        return (Customer) query.getSingleResult();
    }

    @GET
    @Path("/register")
    public Customer register(@QueryParam("username")String username,
                             @QueryParam("password") String pass){
        Customer customer = null;

        Query   query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.username = :username AND c.password = :pass",Customer.class);
        query.setParameter("username",username);
        query.setParameter("pass",pass);

        try
        {
            customer =  (Customer) query.getSingleResult();
            return null;

        }
        catch (NoResultException nre)
        {
//            KieServices kService=KieServices.Factory.get();
//            KieContainer kContainer=kService.getKieClasspathContainer();
//            KieSession kieSession=kContainer.newKieSession("ksession-rules");

            customer = new Customer();
            customer.setPassword(pass);
            customer.setUsername(username);

//            kieSession.insert(customer);
//            kieSession.fireAllRules();

            entityManager.save(customer);
            return customer;
        }
    }
}
