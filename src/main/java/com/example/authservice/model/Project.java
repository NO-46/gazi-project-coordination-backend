package com.example.authservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "project")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE project SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Project  extends BaseEntity {

    @Column
    private String projectName;

    @Column
    private String projectCode;

    @Column
    private String projectDescription;

    @Column
    private String projectStatus;

    @Column
    private String projectType;

    @Column
    private String projectCategory;

    @Column
    private Double projectGroupSize;

    @Column
    private String projectCoworker;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "projects")
    private Set<Term> terms;

    /* @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "projects")
    private Set<Document> documents; */






}
