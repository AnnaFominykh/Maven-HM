package hm.conn_bd.Users;

import org.springframework.data.repository.CrudRepository;

public interface U_Rep extends CrudRepository<User, Integer>
{ public Long countById(Integer id);}


