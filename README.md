#### Добро пожаловать в **Tasker v3**. Учебный проект Лущихина Алексея aka Mu4MaH

##### **О программе**

Программа служит для управления проектами и задачами в группе разработки

- Для создания использовались:
    - Java ver. 1.8
    - Maven ver. 3.6.0

- Список реализуемых технологий: 
    - Generics
    - XML
    - JSON
    - Files r/w
    - JAX-WS
    - WSDL
    - JDBC
    - MyBatis
    - Hibernate
    - JPA
    - SE Weld-cdi
    - Apache Delta Spike
    - Spring
    - Apache Tomcat
    - Servlets
    - SOAP
    - REST
    - React + Redux front
    - Spring Data
    - Spring Security 
    - Spring Boot

- Список  реализованных технологий   
    * Collections


* Version 0.0.1
    * Инициализация проекта. 
    * Создание структуры проекта

* Version 0.0.2
    * Реализация бизнес-логики в сервисном слое
    * Введение проверок пограничных состояний
    * @NotNull и @Nullable аннотации
  
  
```
Build: mvn clean install 
```
```
Postgres via docker config:
Убедитесь, что в системе установлен Docker
docker create -v /var/lib/postgresql/data --name PostgresData alpine
docker run -p 5432:5432 --name yourContainerName -e POSTGRES_PASSWORD=yourPassword -d --volumes-from PostgresData postgres
Подключение к бд идёт на localhost:5432
```
```
Deploy: java -jar ./taskman2.jar
```
