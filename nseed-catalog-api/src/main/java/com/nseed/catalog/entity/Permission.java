package com.nseed.catalog.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERMISSION",uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})})
public class Permission {

	@Id
	@SequenceGenerator(name="permission_seq", sequenceName = "PERMISSION_SQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
	@Column(name = "ID")
	private Long id;

    @Column(name = "NAME")
    private String name;

    //Inverse relationship
    //Bi-directional ManyToMany relationship
    //With mappedBy attribute column will not be created in the table
    @ManyToMany(mappedBy = "permissions")
    @JsonBackReference(value="permissions") // for json infinite recursion problem
    private List<Role> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
