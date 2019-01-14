# Insurance Application

Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Notes

1. Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies.
   The algorithms perform customers’ segmentation according to their financial sophistication, age, location, etc. Thus, all the customers are classified into groups by spotting coincidences in their attitude, preferences, behavior, or personal information. This grouping allows developing attitude and solutions especially relevant for the particular customers.
   [https://medium.com/activewizards-machine-learning-company/top-10-data-science-use-cases-in-insurance-8cade8a13ee1]

# Entities:

    Customer:
        Integer id;
        String name;
        Date birthday;
        Enum gender; //Enum(Male,Female)
        String address;
        String phonenumber;
        String email;
        String observations;
        List<InsurancePolicy> customerPolicies;

    InsurancePolicy: // abstract
        Integer id;
        Enum type; //Enum(Health,Auto,Travel)
        Date starDate;
        Date endDate;
        InsurancePlan plan; // selected plan by customer

    HealthPolicy: // extends InsurancePolicy
        Enum coverageLevel; //Enum(Gold,Silver,Bronze)
        List<HealthData> beneficiaries;

    AutoPolicy: // extends InsurancePolicy
        List<AutoData> beneficiaries
        List<Vehicle> vehicles

    TravelPolicy: // extends InsurancePolicy
        List<Country> destinations;
        List<TravelData> beneficiaries;

    HealthData:
        Customer customer
        Enum healtcareNeeds; //Enum(Low use,Medium use,High use)
        Boolean isSmoker;
        List<Disease> diseases;
        List<Medication> medications;

    AutoData:
        Integer id;
        Customer customer;
        DriverCategory driverCategory;
        Integer drivingExpYears; // years of driving experience
        Integer accidentsInvolved; // number of accidents the person was involved in (he was at fault)
        DriverType driverType;; // Enum(Taxi, PublicTransport, Delivery, ProductTransport, ProfessionalDriver, and Other)

    TravelData: // ! need HealthData
        Integer id;
        Customer customer;
        Enum pourpose; //Enum(Business,Sport,Rest)

    Vehicle:
        Integer id;
        String manufacturer;
        Integer year;
        String model;
        VehicleType type; // Enum(Sedan, Coupe, Hatchback, Convertible, SUV, Motorcycle)
        Double value; // car value, at the moment (?)
        String observations;
        Boolean inLeasing;
        Boolean securitySystem;


    InsurancePlan: // !name package is used in Java
        int id;
        String name;
        String description; // what the package offers
        double price;
        List<Coverage> coverages;
        List<Benefit> benefits;

    Disease:
        Integer id;
        String name;

    Coverage:
        Integer id;
        String name;
        String description;

    Country:
        Integer id;
        String code;
        String name;

    Benefit:
        Integer id;
        String description;
        Double amount;

# BD Schema
![Schema](/_source/schema.jpg)
