package hm.conn_bd;

import hm.conn_bd.Users.User;
import hm.conn_bd.Users.U_Rep;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

import java.util.Optional;

public class UrRep_test {



    @Autowired private U_Rep repo;
    private Object assertThat;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("Susan_Star@gmail.com");
        user.setPassword("123456");
        user.setName("Susan");
        User savedUser = repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){
        Iterable <User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user : users){
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser= repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello2000");
        repo.save(user);
        User updateUser = repo.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hello2000");

    }
    @Test
    public void testGet(){
        Integer userId=2;
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
    @Test
    public void testDelete(){
        Integer userId=2;
        repo.deleteById(userId);
        Optional<User> optionalUser=repo.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();

    }
}