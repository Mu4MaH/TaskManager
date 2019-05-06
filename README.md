#### Добро пожаловать в **Tasker v3**. Учебный проект Лущихина Алексея aka Mu4MaH

##### **О программе**

Программа служит для управления проектами и задачами в группе разработки

- Для создания использовались:
    - Java ver. 1.8
    - Maven ver. 3.6.0

- Список реализуемых технологий: 
    - JAX-WS
    - SOAP
    - JAX-RS
    - REST
    - WSDL
    - MyBatis
    - Hibernate
    - Apache Delta Spike
    - SE Weld-cdi
    - Spring
    - JPA/Spring Data JPA
    - Servlets
    - Spring Security 
    - Spring Boot
    - React + Redux + CSS front

- Список  реализованных технологий:   
    * Collections
    * Generics
    * Files r/w
    * JSON
    * XML
    * JDBC



* Версия 3.0.1
    * Инициализация проекта. 
    * Создание структуры проекта

* Версия 3.0.2
    * Реализация бизнес-логики в сервисном слое
    * Введение проверок пограничных состояний
    * @NotNull и @Nullable аннотации

* Версия 3.0.3
    * реализована работа с in-memory репозиториями для всех сущностей
    * реализован cli для работы с сущностями
    * реализована бизнес-логика приложения

* Версия 3.0.4
    * Добавлены generics в репозитории
    * Выделен интерфейс для репозиториев
    * Выделен абстрактный класс для сущностей
 
* Версия 3.0.5
    * Добавлена сущность Domain
    * Добавлены экспорт/импорт в json формате
    
* Версия 3.0.6
    * Добавлены экспорт/импорт в xml формате
    
* Версия 3.0.7
    * Подключена Postgres БД
    * Репозиторий сущности Task переведён на бд

* Версия 3.0.8
    * Добавлены Unit тесты
    * Рефакторинг команд, сущностей и репозиториев
    * Тип даты в программе изменён на LocalDate
    * Формат хранения даты в БД изменён на строку
    
    
```
Build: mvn clean install 
```
```
Postgres via docker config with persisting data to outer image:
Убедитесь, что в системе установлен Docker
В командной строке наберите по очереди:
docker create -v /var/lib/postgresql/data --name PostgresData alpine
docker run -p 5432:5432 --name TaskManagerDB -e POSTGRES_PASSWORD=password -d --volumes-from PostgresData postgres
Подключение к бд идёт на localhost:5432 c логином postgres и паролем password
Стартовать образ PostgresData не надо!!!
```
```
Deploy: java -jar ./taskman2.jar
```
