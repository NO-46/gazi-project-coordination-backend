package com.example.authservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "deadline")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE deadline SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Deadline extends BaseEntity {

   private String deadlineName;

    private Date deadlineDate;

    //relationlar yazılmalı
    // apply için one to one
    //document one to one olacak
     // proje için de olacak

}
