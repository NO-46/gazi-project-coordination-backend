package com.example.authservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "apply")
@Where(clause = "delete = false")
@SQLDelete(sql = "UPDATE apply SET delete = true, delete_date = CURRENT_DATE WHERE id = ?")
public class Apply extends BaseEntity {

    @Column
    private String applyStatus;

    @Column
    private String applyDescription;

    @Column
    private Date applyDate;

    @Column
    private Date applyStartDate;

    @Column
    private Date applyEndDate;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "applies")
    private List<Group> groups;





}
