package webframe.pojo.persistence;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webframe.dao.UserDao;
import webframe.pojo.FullName;
import webframe.pojo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-dao.xml"})
public class UserServiceTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() throws Exception {
        User user=new User();
        user.setPassword("123123");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);
        System.out.println(userNew.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        User user=new User();
        user.setId("4028c18164fe9ff50164fe9ff7330000");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User update = userDao.update(user);
        System.out.println(update.getId()+":"+update.getFullName());
    }

    /**
     * user id不存在的情况，抛出异常EntityNotFoundException
     * @throws Exception
     */
    @Test
    public void testUpdateException()throws Exception{
        User user=new User();
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);
        userNew.setId("1111111111111111");
        User update = userDao.update(user);
        System.out.println(update.getId()+":"+update.getFullName());
    }

    /**
     * 正常删除：id存在
     * @throws Exception
     */
    @Test
    public void testDelete()throws Exception{
        User user=new User();
        user.setPassword("123123");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);

        int affect=userDao.deteteById(userNew.getId());
        System.out.println(affect);
    }


    /**
     * user id 不存在时删除，异常EntityNotFoundException
     * @throws Exception
     */
    @Test
    public void testDeleteException()throws Exception{
        User user=new User();
        user.setPassword("123123");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);

        int affect=userDao.deteteById(userNew.getId()+"1");
        System.out.println(affect);
//        System.out.println(update.getId()+":"+update.getUsername());
    }

    /**
     * 用户存在，使用正确的id进行查询
     * @throws Exception
     */
    @Test
    public void testFindUserById()throws Exception{
        User user=new User();
        user.setPassword("123123");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);
        User userFind = userDao.findById(userNew.getId());

    }

    /**
     * 用户存在，使用不存在的id进行查询,抛出异常NoResultException
     * @throws Exception
     */
    @Test
    public void testFindUserByIdException()throws Exception{
        User user=new User();
        user.setPassword("123123");
        FullName fullName=new FullName();
        fullName.setFirstName("wu");
        fullName.setLastName("will");
        user.setPassword("123123");
        user.setFullName(fullName);
        User userNew=userDao.insert(user);
        User userFind = userDao.findById(userNew.getId()+"1");

    }

}
