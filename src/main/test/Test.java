

import com.enums.Gender;
import com.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.enums.DriverCategory;
import com.enums.DriverType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		KieServices kService=KieServices.Factory.get();
		KieContainer kContainer=kService.getKieClasspathContainer();
		KieSession kieSession=kContainer.newKieSession("ksession-rules");

		Customer customer = new Customer();
		customer.setName("Test");


		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = format.format( new Date()   );
		Date   date       = null;
		try {
			date = format.parse ( "1996-12-31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customer.setBirthday(date);
		customer.setGender(Gender.MALE);
		customer.setAddress("Iasi");
		customer.setPhonenumber("075 6323 5654");
		customer.setEmail("example@mail.com");
		customer.setObservations("Observations");
		customer.setHealthData(null);
		customer.setTravelData(null);
		customer.setAutoData(null);
		customer.setCustomerPolicies(null);

		AutoData autoData = new AutoData();
		autoData.setAccidentInvolved(5);
		autoData.setDrivingExperience(5);
		autoData.setDriverCategory(DriverCategory.B1);
		autoData.setDriverType(DriverType.TAXIDRIVER);
//		autoData.setCustomer(customer);

		customer.setAutoData(autoData);
		kieSession.insert(autoData);
		kieSession.fireAllRules();
		


		Configuration con =  new Configuration()
				.addPackage("com.model")
				.addAnnotatedClass(AutoData.class)
				.addAnnotatedClass(AutoPolicy.class)
				.addAnnotatedClass(Benefit.class)
				.addAnnotatedClass(Country.class)
				.addAnnotatedClass(Coverage.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Disease.class)
				.addAnnotatedClass(HealthData.class)
				.addAnnotatedClass(HealthPolicy.class)
				.addAnnotatedClass(InsurancePlan.class)
				.addAnnotatedClass(InsurancePolicy.class)
				.addAnnotatedClass(Medication.class)
				.addAnnotatedClass(TravelData.class)
				.addAnnotatedClass(TravelPolicy.class)
				.addAnnotatedClass(Vehicle.class)
				.configure();

		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();		
		
		Transaction transaction = session.beginTransaction();

		session.save(customer);
		autoData.setCustomer(customer);
		session.save(autoData);
		
		transaction.commit();
		session.close();
	}

}
