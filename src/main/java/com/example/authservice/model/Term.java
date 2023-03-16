package com.example.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "term")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE term SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Term extends BaseEntity{

    @Column
    private String termName;

    @Column
    private String termCode;

    @Column
    private Date termStartDate;

    @Column
    private Date termEndDate;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "term_project",
            joinColumns = { @JoinColumn(name = "term_id") },
            inverseJoinColumns = { @JoinColumn(name = "project_id") })
    private Set<Project> projects;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "term_instructor",
            joinColumns = { @JoinColumn(name = "term_id") },
            inverseJoinColumns = { @JoinColumn(name = "instructor_id") })
    private Set<Instructor> instructors;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "term_student",
            joinColumns = { @JoinColumn(name = "term_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "term_group",
            joinColumns = { @JoinColumn(name = "term_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") })
       private Set<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "term_group",
            joinColumns = { @JoinColumn(name = "term_id") },
            inverseJoinColumns = { @JoinColumn(name = "coordinator_id") })
    private Set<Coordinator> coordinators;

}
