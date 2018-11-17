# InsuranceApplication
Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Notes
1) Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies. 
  The algorithms perform customers’ segmentation according to their financial sophistication, age, location, etc. Thus, all the customers are classified into groups by spotting coincidences in their attitude, preferences, behavior, or personal information. This grouping allows developing attitude and solutions especially relevant for the particular customers.
  [https://medium.com/activewizards-machine-learning-company/top-10-data-science-use-cases-in-insurance-8cade8a13ee1]
  
  
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
        InsuranceType type; // enum type (Health, Travel, Auto, and Property)
        Date startDate;
        Date endDate;
        Customer customer;
    
    // https://www.healthcare.gov/choose-a-plan/plans-categories/
    PolicyHealth: // extends InsurancePolicy
        ArrayList<CustomerHealthPol> peopleCovered; // people covered by the insurance policy
        // https://www.bupa.com.au/staticfiles/BupaP3/pdfs/09638-standard-retail-app-form.pdf
        ArrayList<Package> packages; // selected policy packages (/ categories ?)
        
    // https://www.techemergence.com/artificial-intelligence-in-health-insurance-current-applications-and-trends/
    CustomerHealthPol: // extends Customer
        boolean isSmoker;
        ArrayList<MedicalConditions> medicalConditions; // enum type (permanent medical conditions / long term(?), e.g. Parkinson's, scoliosis etc.)
    
    // https://www.policybazaar.com/travel-insurance/
    PolicyTravel: // extends InsurancePolicy
        ArrayList<Countries> destinations; // enum type
        ArrayList<Customer> peopleCovered; // people covered by the insurance policy
        boolean hasMedicalConditions; // if any person has any medical condition
        ArrayList<Package> packages; // selected policy packages (/ categories ?)
        
    PolicyAuto: // extends InsurancePolicy
        // here, Customer object will be of type CustomerAutoPol
        CustomerVehicle vehicle;
        ArrayList<Package> packages; // selected policy packages (/ categories ?)
    
    // https://www.policybazaar.com/motor-insurance/
    CustomerAutoPol: // extends Customer
        int drivingExpYears; // years of driving experience
        int accidentsInvolved; // number of accidents the person was involved in (he was at fault)
        // https://en.wikipedia.org/wiki/List_of_professional_driver_types
        FieldOfWork fieldOfWork; // enum type (Taxi, PublicTransport, Delivery, ProductTransport, ProfessionalDriver, and Other)
    
    CustomerVehicle:
        String id; // identification number / chassis number
        String registrationNumber; // license number/plate
        String manufacturer;
        String model;
        Color color; // enum type (Red, Blue, Green, Yellow, Black, and White)
        VehicleType type; // enum type (Sedan, Coupe, Hatchback, Convertible, SUV, Motorcycle)
        int manufacturingYear; // the year it was manufactured
        double value; // car value, at the moment (?)
        String observations;
        Customer owner;
        PolicyAuto policy;
        
    PolicyProperty: // extends InsurancePolicy
        ...
    
    Package: // each package offer can have exclusions (RULES which allow the customer to choose it or not); check PolicyTravel link for examples
        int id;
        String name;
        String description; // what the package offers
        double price;
    
