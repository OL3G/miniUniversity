package com.kurishev.miniUniversity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "GROUPS")
public class GroupEntity extends BaseEntity{
    @Column(name ="GROUP_NAME",unique = true)
    private String group;

    @OneToMany
    @JoinColumn(name = "STUDENT_ID")
    private List<StudentEntity> students;
}
