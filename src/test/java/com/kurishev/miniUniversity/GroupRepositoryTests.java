package com.kurishev.miniUniversity;

import com.kurishev.miniUniversity.model.GroupEntity;
import com.kurishev.miniUniversity.repository.GroupRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupRepositoryTests {
    @Autowired
    GroupRepository groupRepository;

    @Test
    public void addGroupWhenFindItByName() {
        GroupEntity group = new GroupEntity();
        group.setGroup("2381");
        groupRepository.save(group);
        GroupEntity findGroup = groupRepository.findByGroup("2381");
        assertNotNull(findGroup);
        assertEquals("2381", findGroup.getGroup());
    }
}
