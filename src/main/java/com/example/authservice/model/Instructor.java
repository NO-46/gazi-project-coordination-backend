package com.example.authservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "instructor")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE instructor SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Instructor extends User {
    @Column
    private String instructorNumber;

    @Column
    private String instructorDepartment;

    @Column
    private String instructorFaculty;

    @Column
    private String instructorTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Set<Group> groups;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor")
    private Set<Project> projects;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "instructors")
    private Set<Term> terms;

    @OneToMany(mappedBy = "instructor")
    private Set<Document> documents;


}
