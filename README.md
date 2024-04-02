# Spring Boot Hibernate Envers Audit History Logging with Composite Primary Key
I created this repository for stackoverflow question.
https://stackoverflow.com/a/78233804/806347

### How to run?

- Docker
```shell
docker build -t tayfun-hibernate . && docker run -d -p 8080:8080 tayfun-hibernate
```

- Maven
```shell
mvn spring-boot:run
```


### How Can I use?

- Use ```@Audited``` for generate audit history of entity

```java

@Audited
@Entity
public class User extends BaseEntity {
```

- If you want to mark field for not auditing use ```@NotAudited```

```java
@NotAudited
@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
private List<Address> addresses;
```

#### USER_AUD

| ID | REV | REVTYPE | NAME           | USERNAME |
|----|-----|---------|----------------|----------|
| 1  | 1   | 0       | tayfun         | @tayfunUsername    |
| 2  | 2   | 0       | tayfun2        | @tayfunUsername2   |
| 1  | 3   | 1       | tayfun_UPDATE  | @tayfunUsername    |
| 1  | 4   | 1       | tayfun_UPDATE2 | @tayfunUsername    |
| 1  | 5   | 1       | tayfun_UPDATE  | @tayfunUsername    |

#### ADDRESS_AUD

| ID | REV | REVTYPE | CITY             | COUNTRY      | STREET           | USER_ID  |
|----|-----|---------|------------------|--------------|------------------|----------|
| 1  | 7   | 0       | Manisa         | TR           | Sehzadeler           | 2        |
| 1  | 8   | 1       | Manisa_UPDATED | TR_UPDATED   | Sehzadeler_UPDATED   | 2        |

#### REVINFO

| REV | REVTSTMP        |
|-----|----------------|
| 1   | 1686001700932  |
| 2   | 1686001705279  |
| 3   | 1686001719637  |
| 4   | 1686001737580  |
| 5   | 1686001743540  |
| 6   | 1686001784099  |

### Source:

https://stackoverflow.com/a/78233804/806347
