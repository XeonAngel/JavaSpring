package com.example.JavaSpringProject.tests;

import com.example.JavaSpringProject.models.Drug;
import com.example.JavaSpringProject.models.Enums.Rank;
import com.example.JavaSpringProject.models.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    public void findDrug() {
        Drug drugFound = entityManager.find(Drug.class, 1L);
        assertEquals(drugFound.getName(), "Flucovim");
    }

    @Test
    public void updateStaff() {
        Staff staffFound = entityManager.find(Staff.class, 1L);
        staffFound.setStaffRank(Rank.General);

        entityManager.persist(staffFound);
        entityManager.flush();
    }

    @Test
    public void checkRankUpdate() {
        updateStaff();
        Staff staffFound = entityManager.find(Staff.class, 1L);
        assertEquals(staffFound.getStaffRank(), Rank.General);
    }
}
