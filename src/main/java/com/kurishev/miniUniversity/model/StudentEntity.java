package com.kurishev.miniUniversity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "STUDENTS")
public class StudentEntity extends BaseEntity{
    @Column(name ="NAME")
    private String name;

    @Column(name = "AGE")
    private String age;
}
