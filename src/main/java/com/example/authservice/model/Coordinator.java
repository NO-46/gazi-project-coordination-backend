package com.example.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "coordinator")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE coordinator SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Coordinator extends User {

    @Column
    private String coordinatorNumber;

    @Column
    private String coordinatorDepartment;

    @Column
    private String coordinatorFaculty;

    @Column
    private String coordinatorTitle;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "coordinators")
    private Set<Term> terms;

    @OneToMany(mappedBy = "coordinator")
    private Set<Document> documents;


}
