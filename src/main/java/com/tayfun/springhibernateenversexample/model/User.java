package com.tayfun.springhibernateenversexample.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Getter
@Setter
@Table(name = "`user`")
@NoArgsConstructor
public class User extends BaseEntity {

    private String name;

    @OneToMany
    private List<UserCompanyRole> userCompanyRoles = new ArrayList<>();
}
