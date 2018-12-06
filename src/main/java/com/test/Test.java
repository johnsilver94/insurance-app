package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.enums.DriverCategory;
import com.enums.DriverType;
import com.model.AutoData;

public class Test {
	private static KieSession kieSession = null;
	public static void main(String[] args) {
		
		KieServices kService=KieServices.Factory.get();
		KieFileSystem kfs = kService.newKieFileSystem();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("Drools/Rules/rules.drl");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		kfs.write( "src/main/resources/simple.drl",
				kService.getResources().newInputStreamResource(fis));
		
	    KieBuilder kieBuilder = kService.newKieBuilder(kfs).buildAll();
	    Results results = kieBuilder.getResults();
	    if( results.hasMessages(Message.Level.ERROR) ){
	        System.out.println( results.getMessages() );
	        throw new IllegalStateException( "### errors ###" );
	    }

	    KieContainer kieContainer = kService.newKieContainer( kService.getRepository().getDefaultReleaseId() );

	    KieBase kieBase = kieContainer.getKieBase();
	    kieSession = kieContainer.newKieSession();
		// TODO Auto-generated method stub
		AutoData autoData = new AutoData();
		autoData.setId(1);
		autoData.setAccidentInvolved(5);
		autoData.setDrivingExperience(5);
		autoData.setDriverCategory(DriverCategory.B1);
		autoData.setDriverType(DriverType.TAXIDRIVER);
			
		kieSession.insert(autoData);
		kieSession.fireAllRules();
		
		
		Configuration con =  new Configuration().configure().addAnnotatedClass(AutoData.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();		
		
		Transaction transaction = session.beginTransaction();
		session.save(autoData);
		
		transaction.commit();
		session.close();
	}

}
