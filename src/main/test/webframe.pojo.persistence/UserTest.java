package webframe.pojo.persistence;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class UserTest {


    private EntityManagerFactory entityManager;

    @Before
    public void init (){
        entityManager= Persistence.createEntityManagerFactory("will-unit");
    }

    @Test
    public  void testCreateSql(){
        System.out.println("testCreateSql");
    }



}
