package com.example.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "document")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE document SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Document extends BaseEntity {

    @Column
    private String documentName;
    @Column
    @JsonIgnore
    private String documentUrl;

    @JsonIgnore
    @Column
    private Date documentDeadline;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "coordinator_id")
    private Coordinator coordinator;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;


}
