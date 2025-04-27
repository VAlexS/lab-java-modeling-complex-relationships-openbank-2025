![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB Java | Modeling Complex Relationships

## Introduction

We have just learned how to use Relationship Mapping to model 1 to 1 relationship and 1 to many relationships so let's practice a bit more.

<br>

## Requirements

1. Fork this repo.
2. Clone this repo.
3. Add your instructor and the class graders as collaborators to your repository. If you are unsure who your class graders are, ask your instructor or refer to the day 1 slide deck.
4. In the repository, create a Java project and add the code for the following prompts.

## Submission

Once you finish the assignment, submit a URL link to your repository or your pull request in the field below.

<br>

## Instructions

1. Using the Spring JPA model, create the relationships for an application for an Association of Nurses. The Association has 7 Chapters and each Chapter has the following properties:

   - `name`: the name of the chapter
   - `district`: the geographical district the chapter belongs to
   - `president`: a Member object representing the chapter's president
   - `list`: a list of Member objects representing the chapter's members

- Each Member has the following properties:

  - `name`: the member's name
  - `status`: the member's status, which can be _ACTIVE_ or _LAPSED_
  - `renewal date`: the date on which the member's membership will be renewed


 Para cumplir con los requerimientos, el diagrama UML que me he planteado es este:

 ![image](https://github.com/user-attachments/assets/8de9069c-6e7f-4eec-8f76-d729fa434447)


 Cuya sintaxis correspondiente es esta

 ![image](https://github.com/user-attachments/assets/d8ef3f86-0e78-4676-a434-809b7e533fbd)

En cuanto a las tablas creadas en mySQL, he creado estas tablas

![img.png](img.png)

 


2. Using the Spring JPA model, create the relationships for an Event Management application. The application needs to model upcoming events, which can be of two types: Conferences or Expositions.

- Each event has the following properties:

  - `date`: the date the event will take place
  - `duration`: the duration of the event
  - `location`: the location of the event
  - `title`: the title of the event
  - `list`: a list of guests that are invited to the event.

- Each guest has the following properties:
  - `name`: the guest's name
  - `status`: the guest's response, which can be _ATTENDING_, _NOT_ATTENDING_, or _NO_RESPONSE_

In addition to the typical event properties, Conferences also have a list of Speakers.

- Each Speaker has the following properties:
  - `name`: the speaker's name
  - `presentationDuration`: the duration of the presentation.

Para este ejercicio, he realizado el siguiente diagrama UML


@startuml
class Event {
- id: int
- date: Date
- duration: int
- location: String
- title: String
- list: List<Guest>
  }

class Guest {
- id: int
- name: String
- status: Status
  }

enum Status {
- ATTENDING
- NOT_ATTENDING,
- NO_RESPONSE
  }

class Speaker {
- id: int
- name: String
- presentationDuration: int
  }

Event "1" o-- "*" Guest

Event "1" o-- "*" Speaker
@enduml

El diagrama UML quedaría así

![img_1.png](img_1.png)

Para que se cumplan los requerimientos, así es como he creado las tablas

![img_6.png](img_6.png)

Las relaciones establecidas entre tablas son

![img_7.png](img_7.png)

![img_8.png](img_8.png)


Tras probar con testing que todo se guarda correctamente, así se muestran los resultados

![img_9.png](img_9.png)

![img_10.png](img_10.png)

![img_11.png](img_11.png)

3. Create a simple **Use Case Diagram** illustrating how a user (e.g., admin, member, or guest) interacts with **either** the Association of Nurses or the Event Management application. Identify the main **actors** and the **use cases** (e.g., update membership, schedule an event, invite guests).

4. Create a **UML Class Diagram** for one (or both) of the domains above:

   - **Association of Nurses**: Show how `Chapter` and `Member` relate.
   - **Event Management**: Show how `Event`, `Conference`, `Exposition`, `Guest`, and `Speaker` relate.

   Indicate attributes and methods (even if briefly) and the relationships (e.g., `1..*`, `@OneToMany`, etc.).

5. Export a screenshot or PDF of your diagrams and include them in your repository or attach them to your README. This will help demonstrate your system design before or alongside your code.

<br>

## FAQs

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">I am stuck and don't know how to solve the problem or where to start. What should I do?</summary>

<br> <!-- ✅ -->

If you are stuck in your code and don't know how to solve the problem or where to start, you should take a step back and try to form a clear, straight forward question about the specific issue you are facing. The process you will go through while trying to define this question, will help you narrow down the problem and come up with potential solutions.

For example, are you facing a problem because you don't understand the concept or are you receiving an error message that you don't know how to fix? It is usually helpful to try to state the problem as clearly as possible, including any error messages you are receiving. This can help you communicate the issue to others and potentially get help from classmates or online resources.

Once you have a clear understanding of the problem, you should be able to start working toward the solution.

 </details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">How do I create a Spring boot project?</summary>

<br> <!-- ✅ -->

Spring boot is a framework for creating stand-alone, production-grade applications that are easy to launch and run. The best way to create a Spring boot project is to use the Spring Initializer website. The website provides a convenient way to generate a basic project structure with all the necessary dependencies and configurations.

- Step 1: Go to [start.spring.io](https://start.spring.io/)
- Step 2: Choose the type of project you want to create, such as Maven or Gradle.
- Step 3: Select the version of Spring Boot you want to use.
- Step 4: Choose the dependencies you need for your project. Some common dependencies include web, jpa and data-jpa.
- Step 5: Click the "Generate" button to download the project files.

Alternatively, you can use an Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA. These IDEs have plugins for creating Spring boot projects, making it easy to set up the environment and get started with coding.

 </details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is JPA and how can I use it in Java?</summary>

<br> <!-- ✅ -->

JPA stands for Java Persistence API, which is a Java specification for accessing, persisting and managing data between Java objects and a relational database. JPA provides a standard interface for accessing databases, reducing the need for custom data access code and enabling efficient management of database connections.

To use JPA in Java, you will need to include the necessary dependencies in your project, such as the Hibernate JPA implementation and create entity classes to represent your data. These entity classes will be annotated with JPA-specific annotations, such as `@Entity` and `@Id`, to indicate the mapping between the Java class and the database table.

Here is a code snippet to show you how to create a JPA entity class in Java:

```java
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  private String name;
  private int age;
  private String position;

  // Getters and Setters for the attributes
}
```

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is the purpose of using the "@Entity", "@Table" and "@Column" annotations in JPA (Java Persistence API)?</summary>

<br> <!-- ✅ -->

The `@Entity`, `@Table` and `@Column` annotations in JPA (Java Persistence API) are used to map Java objects to relational database tables.

`@Entity` is used to mark a class as a persistent entity. This means that instances of the class can be stored in a database.

`@Table` is used to define the name of the database table that the entity will be mapped to.

`@Column` is used to define the columns in the table that correspond to the attributes of the entity.

Here is an example of how to use these annotations:

```java
@Entity
@Table(name="employee")
public class Employee {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
  private int id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  //getters and setters
}
```

In this example, the `Employee` class is marked as a persistent entity using the `@Entity` annotation. The name of the database table is defined using the `@Table` annotation as "employee". The `id`, `firstName` and `lastName` attributes are mapped to columns in the "employee" table using the `@Column` annotation.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is the difference between "JOINED", "TABLE_PER_CLASS" and "SINGLE_TABLE" inheritance strategies in JPA and when to use them?</summary>

<br> <!-- ✅ -->

The `@Inheritance` annotation in JPA can be used to specify inheritance strategy for entities in JPA. There are three strategies available in JPA: `SINGLE_TABLE`, `JOINED` and `TABLE_PER_CLASS`. The inheritance strategy is specified using the strategy attribute in the `@Inheritance` annotation.

The inheritance strategies in JPA determine how the data is stored in the database for the entities that inherit from a parent entity.

- **JOINED strategy**: creates separate tables for each concrete entity and a join between them is used to retrieve the data.

  ```java
  @Inheritance(strategy=InheritanceType.JOINED)
  @Entity
  public class Parent {
  // ...
  }
  ```

- **TABLE_PER_CLASS strategy**: creates a separate table for each concrete entity and includes all the columns of the parent entity as well.

  ```java
  @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
  @Entity
  public class Parent {
  // ...
  }
  ```

- **SINGLE_TABLE strategy**: creates a single table for all the entities in the hierarchy, including a discriminator column to distinguish between the entities.

  ```java
  @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
  @Entity
  public class Parent {
  // ...
  }
  ```

The choice of inheritance strategy depends on the requirements of the application, such as the need for normalization, the number of columns in the table and the number of joins required to retrieve data. For example, if the entities have many columns and normalization is important, then JOINED strategy is appropriate. If there are fewer columns, the TABLE_PER_CLASS strategy may be more suitable. The SINGLE_TABLE strategy is the simplest and most compact but may result in a less flexible data model.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">What is "JpaRepository" and how can I use it in Java?</summary>

<br> <!-- ✅ -->

`JpaRepository` is a Spring Data interface that extends the `PagingAndSortingRepository` interface. It provides all the basic **CRUD (Create, Read, Update, Delete)** operations and additional methods to work with **JPA (Java Persistence API)** to interact with the database.

To use `JpaRepository` in your project, follow the below steps:

Step 1: Import the necessary libraries

```java
import org.springframework.data.jpa.repository.JpaRepository;
```

Step 2: Create an interface that extends `JpaRepository`

```java
public interface MyRepository extends JpaRepository<MyEntity, Long> {

}
```

**Note**: In the above code, `MyEntity` is the entity class that you want to interact with the database and Long is the type of the primary key of `MyEntity`.

Step 3: Inject the interface in the class where you want to use it.

```java
@Autowired
private MyRepository myRepository;
```

Step 4: You can now use the methods provided by `JpaRepository` to interact with the database, for example:

```java
MyEntity myEntity = new MyEntity();
myRepository.save(myEntity);
```

With the above steps, you can now use `JpaRepository` to interact with the database in your Java project.

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">How can I use the JPA annotations "@OneToOne", "@OneToMany", "@ManyToOne", "@ManyToMany", "@JoinColumn" and "@JoinTable" in Java?</summary>

<br> <!-- ✅ -->

The Java Persistence API (JPA) provides several annotations for mapping relationships between entities in Java applications. These annotations include:

1. **@OneToOne**: This annotation is used to define a one-to-one relationship between two entities. The following code shows how to use the `@OneToOne` annotation:

```java
@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  private Address address;

  // Getters and setters ...
}

@Entity
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String street;

  private String city;

  // Getters and setters ...
}
```

2. **@OneToMany & @ManyToOne**: These annotations are used to define one-to-many and many-to-one relationships between two entities.

The following code shows how to use the `@OneToMany` and the `@ManyToOne` annotation:

```java
@Entity
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees;

  // Getters and setters ...
}

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "department_id", referencedColumnName = "id")
  private Department department;

  // Getters and setters ...
}
```

3. **@ManyToMany & @JoinColumn & @JoinTable**: The `@ManyToMany` annotation is used in Java to define a many-to-many relationship between two entities. This means that multiple instances of one entity can be related to multiple instances of another entity.

The `@JoinColumn` annotation is used in Java to specify the foreign key column that will be used to join the two entities. The foreign key column is used to establish a relationship between the entities.

The `@JoinTable` annotation is used in Java to define a join table for a many-to-many relationship. The join table is used to store the relationship information between the two entities.

The following code shows how to use the `@ManyToMany`, `@JoinColumn` and `@JoinTable` annotations:

```java
@Entity
public class User {

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}

@Entity
public class Role {

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
```

</details>

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">I am unable to push changes to my repository. What should I do?</summary>

<br> <!-- ✅ -->

If you are unable to push changes to your repository, here are a few steps that you can follow:

1. Check your internet connection: Ensure that your internet connection is stable and working.
1. Verify your repository URL: Make sure that you are using the correct repository URL to push your changes.
1. Check Git credentials: Ensure that your Git credentials are up-to-date and correct. You can check your credentials using the following command:

```bash
git config --list
```

4. Update your local repository: Before pushing changes, make sure that your local repository is up-to-date with the remote repository. You can update your local repository using the following command:

```bash
git fetch origin
```

5. Check for conflicts: If there are any conflicts between your local repository and the remote repository, resolve them before pushing changes.
6. Push changes: Once you have resolved any conflicts and updated your local repository, you can try pushing changes again using the following command:

```bash
git push origin <branch_name>
```

</details>
