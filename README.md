# InsuranceApplication [Drools Test]

Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Quick setup (using IntelliJ Idea)

1. Install latest version of JDK.
2. Download repository(using git or manual)
4. Open project and Add as a Maven project
5. Setup SDK
7. Setup project persistence
8. Run Test

### Persistence setup

- Open persistence.xml (src/main/resources/META-INF) and change datasource credentials

```xml
<properties>
    <property name="hibernate.connection.url" value="jdbc:oracle:thin:@localhost:1521:[Your SID]" />
    <property name="hibernate.connection.driver_class"  value="oracle.jdbc.OracleDriver" />
    <property name="hibernate.connection.username" value="[Your username]" />
    <property name="hibernate.connection.password" value="[Your password]" />
    <property name="hibernate.dialect" value="org.hibernate.dialect.Oracle10gDialect"/>
    <property name="hibernate.hbm2ddl.auto" value="create" />
    <property name="hibernate.show_sql" value="true" />
    <property name="hibernate.c3p0.min_size" value="5" />
    <property name="hibernate.c3p0.max_size" value="20" />
    <property name="hibernate.c3p0.timeout" value="300" />
</properties>
```

# Design and Development

Used technologies:

- Oracle database 18c
- IntelliJ Idea
- Maven (dependecy management)
- Tomcat (Application server)

## BD Schema

![Schema](/_source/schema.jpg)


## Notes

Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies.
The algorithms perform customers’ segmentation according to their financial sophistication, age, location, etc. Thus, all the customers are classified into groups by spotting coincidences in their attitude, preferences, behavior, or personal information. This grouping allows developing attitude and solutions especially relevant for the particular customers.
[Top 10 Data Science Use Cases in Insurance](https://medium.com/activewizards-machine-learning-company/top-10-data-science-use-cases-in-insurance-8cade8a13ee1)
