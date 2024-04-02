package com.tayfun.springhibernateenversexample.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Getter
@Setter
@Table
@NoArgsConstructor
public class UserCompanyRole {

    @EmbeddedId
    private UserCompanyRoleId userCompanyRoleId;
}
