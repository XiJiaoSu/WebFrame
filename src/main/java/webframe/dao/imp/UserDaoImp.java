package webframe.dao.imp;

import org.springframework.stereotype.Repository;
import webframe.dao.UserDao;
import webframe.pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository("userDao")
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @Override
    public User insert(User user) throws Exception {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    @Override
    public User update(User user) throws Exception {
        User userEm = entityManager.getReference(User.class,user.getId());
        userEm.setPassword(user.getPassword());
        userEm.setFullName(user.getFullName());
        entityManager.flush();
        return userEm;
    }

    @Override
    public User findById(String id) throws Exception {
        String find_by_id="from User where id=:id";
        return (User) entityManager.createQuery(find_by_id).setParameter("id",id).getSingleResult();
    }

    @Override
    public User list() throws Exception {
        return null;
    }

    @Transactional
    @Override
    public int deteteById(String id) throws Exception {
        String delete_by_id="delete from User where id=:id";
        return entityManager.createQuery(delete_by_id).setParameter("id", id).executeUpdate();
        
    }
}
