# InsuranceApplication

Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Notes

1. Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies.
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
        String observations;
        List<InsurancePolicy> customerPolicy

    InsurancePolicy: // abstract
        Integer id;
        Enum type;
        Date starDate;
        Date endDate;
        Boolean selfInclude;
        InsurancePlan plan; // selected plan by customer

    HealthPolicy: // extends InsurancePolicy
        Enum coverageLevel; //Enum(Gold,Silver,Bronze)
        List<HealthData> beneficiaries;

    AutoPolicy: // extends InsurancePolicy
        List<AutoData> beneficiaries
        List<Vehicle> vehicles

    TravelPolicy: // extends InsurancePolicy
        List<Country> destinations;
        List<TravelData> beneficiary;

    HealthData:
        Customer customer
        Enum healtcareNeeds;
        Boolean isSmoker;
        List<Disease> diseases;
        List<Medication> medications;

    AutoData:
        Integer id;
        Customer customer;
        DriverCategory driverCategory;
        int drivingExpYears; // years of driving experience
        int accidentsInvolved; // number of accidents the person was involved in (he was at fault)
        DriverType driverType;; // enum type (Taxi, PublicTransport, Delivery, ProductTransport, ProfessionalDriver, and Other)

    TravelData:
        Integer id;
        Customer customer;
        TouristType touristType;
        Enum healtcareNeeds;

    Vehicle:
        Integer id;
        String manufacturer;
        Integer year;
        String model;
        VehicleType type; // enum type (Sedan, Coupe, Hatchback, Convertible, SUV, Motorcycle)
        Double value; // car value, at the moment (?)
        String observations;
        Boolean inLeasing;
        Boolean securitySystem;


    InsurancePlan: // !name package is used in Java
        int id;
        String name;
        String description; // what the package offers
        InsuranceType type; // see InsurancePolicy class for the enum type
        double price;
