# InsuranceApplication
Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Notes
/*
1) Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies. 
  The algorithms perform customers’ segmentation according to their financial sophistication, age, location, etc. Thus, all the customers are classified into groups by spotting coincidences in their attitude, preferences, behavior, or personal information. This grouping allows developing attitude and solutions especially relevant for the particular customers.
  [https://medium.com/activewizards-machine-learning-company/top-10-data-science-use-cases-in-insurance-8cade8a13ee1]
*/
  
# Entities:
    Customer:
        int id;
        String name;
        Date birthday;
        Enum gender;
        String address;
        String phoneNumber;
        String email;
        InsurancePolicy insurancePolicy;
        String observations;
    
    InsurancePolicy:
        int id;
        String name;
        InsuranceType type; // enum type
        Date startDate;
        Date endDate;
        Customer customer;
    
    // https://www.healthcare.gov/choose-a-plan/plans-categories/
    PolicyHealth: // extends InsurancePolicy
        ArrayList<Customer> peopleCovered; // people covered by the insurance policy
        // https://www.bupa.com.au/staticfiles/BupaP3/pdfs/09638-standard-retail-app-form.pdf
        ArrayList<Package> packages; // selected health packages (/ categories ?)
        
    // https://www.techemergence.com/artificial-intelligence-in-health-insurance-current-applications-and-trends/
    CustomerHealth: // extends Customer
        boolean isSmoker;
        ArrayList<HealthIssues> healthIssues; // enum type (permanent conditions / long term conditions ?, e.g. Parkinson's, scoliosis)
    
    PolicyTravel: // extends InsurancePolicy
        ...
        
    PolicyCar: // extends InsurancePolicy
        ...
        
    PolicyProperty: // extends InsurancePolicy
        ...
    
    Package:
        int id;
        String name;
        double price;
    
