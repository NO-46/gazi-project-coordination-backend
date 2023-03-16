package com.example.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "groups")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE groups SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Group extends BaseEntity {
    @Column
    private String groupName;

    @Column
    private String groupCode;

    @Column
    private String groupDescription;

    @Column
    private int groupCapacity;

    @Column
    private int groupCurrentCapacity;

    @Column
    private String groupStatus;

    @Column
    private double leastGpa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Document> documents;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "group_apply",
            joinColumns = { @JoinColumn(name = "group_id") },
            inverseJoinColumns = { @JoinColumn(name = "apply_id") })
    private List<Apply> applies;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "group")
    private Project project;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "groups")
    private Set<Term> terms;

    @OneToMany(mappedBy = "group")
    private Set<Student> students;

    @OneToMany(mappedBy = "group")
    private Set<Document> document;




    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "groups")
    private Set<Document> documents; */


}
