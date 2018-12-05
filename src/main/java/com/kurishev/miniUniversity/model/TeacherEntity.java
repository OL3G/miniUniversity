package com.kurishev.miniUniversity.model;
import com.kurishev.miniUniversity.model.GroupEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "TEACHERS")
public class TeacherEntity extends BaseEntity {
    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "TEACHER_GROUP", joinColumns = {@JoinColumn(name ="TEACHER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    private Set<GroupEntity> groups;

    public void addGroup(GroupEntity groupEntity){
        if (groups == null) groups = new HashSet<>();
        groups.add(groupEntity);
    }
}
