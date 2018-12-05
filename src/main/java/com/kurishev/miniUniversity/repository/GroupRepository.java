package com.kurishev.miniUniversity.repository;

import com.kurishev.miniUniversity.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity,Long> {
    GroupEntity findByGroup(String group);
}
