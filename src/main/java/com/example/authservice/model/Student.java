package com.example.authservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.annotation.security.RolesAllowed;
import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE student SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Student extends User {

    @Column
    private String studentNumber;

    @Column
    private String studentClass;

    @Column
    private String studentDepartment;

    @Column
    private String studentFaculty;

    @Column
    private Double studentGPA;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    private Set<Term> terms;

    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "students")
    private Set<Document> documents;
*/

    @OneToMany(mappedBy = "student")
    private Set<Document> documents;


}
