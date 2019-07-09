# InsuranceApplication [REST service on Wildfly Server]

Insurance policies on various domains (agriculture/ health, holidays, cars and individual property)

# Quick setup (using IntelliJ Idea)

1. Install latest version of JDK.
2. Install [Wildfy server](https://drive.google.com/file/d/1WcN83VJzVDkrXaaq-0FxGV0k57G6DyZN/view?usp=sharing).
3. Download repository(using git or manual)
4. Open project and Add as a Maven project
5. Setup SDK
6. Setup Wildfly server
7. Setup project persistence
8. Deploy and run server
9. Base address is http://localhost:8080/insurance-application

### Wildfly server configuration

!! Wildfly server from the second step have Oracle driver installed, and admin user are setup with credentials:

- username: wildfly
- password: wildfly

Now user need just to set Oracle database in Wildfly configuration (Wildlfy\standalone\configuration\standalone.xml)

1. Find datasources section in standalone.xml
2. Change datasource configuration with yours

```xml
<datasource jndi-name="java:jboss/datasources/[Your datasource name]" pool-name="[Your pool name]" enabled="true" use-java-context="true">
    <connection-url>jdbc:oracle:thin:@localhost:1521:john</connection-url>
    <driver>oracle</driver>
    <pool>
        <min-pool-size>1</min-pool-size>
        <max-pool-size>5</max-pool-size>
        <prefill>true</prefill>
    </pool>
    <security>
        <user-name>[Your username]</user-name>
        <password>[Your password]</password>
    </security>
</datasource>
```  

- Now add Wildfly server as [Run configuration in IntelliJ](https://www.youtube.com/watch?v=ra72h2K9vJY).

### Persistence setup

- Open hibernate.cfg.xml (src/main/resources/hibernate.cfg.xml) and change datasource credentials

```xml
 <session-factory>
  <property name="hibernate.connection.driver_class">oracle.jdbc.OracleDriver</property>
  <property name="hibernate.connection.password">[Your password]</property>
  <property name="hibernate.connection.url">jdbc:oracle:thin:@localhost:1521:[Your SID]</property>
  <property name="hibernate.connection.username">[Your username]</property>
  <property name="hibernate.dialect">org.hibernate.dialect.Oracle10gDialect</property>
  <property name="hibernate.hbm2ddl.auto">create</property>
  <property name="hibernate.c3p0.timeout">50000</property>
  <property name="hibernate.show_sql">true</property>
  <property name="hibernate.cache.provider_class">org.hibernate.jpa.HibernatePersistenceProvider</property>
.....
</session-factory>
```

- Open persistence.xml and change configuration with yours

```xml
<jta-data-source>java:jboss/datasources/[Your datasource name]</jta-data-source>
```

# Design and Development

## Used technologies

- Oracle database 18c
- IntelliJ Idea
- Maven (dependecy management)
- Postman (REST client)

## BD Schema

![Schema](/_source/schema.jpg)

## REST

- /resources/customers/auth
    - used for authentication
    - parameters keys
        - username
        - password
- /resources/customers/
    - get customers/users list
- /resources/customers/{id}
    - get customer by {id}
- /resources/customers/register
    - register/add new customer
    - parameters keys
        - username
        - password

## Notes

Customer segmentation: Different customers tend to have specific expectations for the insurance business. Insurance marketing applies various techniques to increase the number of customers and to assure targeted marketing strategies.
The algorithms perform customers’ segmentation according to their financial sophistication, age, location, etc. Thus, all the customers are classified into groups by spotting coincidences in their attitude, preferences, behavior, or personal information. This grouping allows developing attitude and solutions especially relevant for the particular customers.
[Top 10 Data Science Use Cases in Insurance](https://medium.com/activewizards-machine-learning-company/top-10-data-science-use-cases-in-insurance-8cade8a13ee1)
