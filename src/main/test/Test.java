

import com.enums.Gender;
import com.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.enums.DriverCategory;
import com.enums.DriverType;
import javax.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		KieServices kService=KieServices.Factory.get();
		KieContainer kContainer=kService.getKieClasspathContainer();
		KieSession kieSession=kContainer.newKieSession("ksession-rules");

		Customer customer = new Customer();
		Profile profile = new Profile();
		customer.setEmail("example2@mail.com");
		customer.setUsername("test4");
		customer.setPassword("pass");
		customer.setObservations("Observations");
		customer.setAutodata(null);
		customer.setProfile(null);
		customer.setHealthdata(null);
		customer.setTraveldata(null);
		customer.setPolicies(null);


		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date   date       = null;
		try {
			date = format.parse ( "1996-12-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		profile.setName("Name");
		profile.setSurname("Surname");
		profile.setBirthday(date);
		profile.setGender(Gender.MALE);
		profile.setAddress("Iasi");
		profile.setPhonenumber("075 6323 5654");
		profile.setSsc("2132141343542343");
		profile.setWork("No work");

//		customer.setProfile(profile);

		AutoData autoData = new AutoData();
		autoData.setLicenseId("as8809723423423");
		autoData.setAccidents(5);
		autoData.setExprience(5);
		autoData.setCategory(DriverCategory.B1);
		autoData.setType(DriverType.TAXIDRIVER);
//
//		customer.setAutodata(autoData);

		kieSession.insert(autoData);
		kieSession.fireAllRules();
		


		Configuration con =  new Configuration().configure();
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		if(!session.beginTransaction().isActive()) {
            session.beginTransaction().begin();
        }

        session.save(customer);
		autoData.setCustomer(customer);
		profile.setCustomer(customer);

		customer.setAutodata(autoData);
		customer.setProfile(profile);
		session.update(customer);

		session.getTransaction().commit();
        Query query = session.createQuery("SELECT c FROM Customer c");

        List customers = query.getResultList();

        System.out.println(""+customers.size());
		session.close();


	}

}
