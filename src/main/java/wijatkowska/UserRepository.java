package wijatkowska;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

@Transactional
public interface UserRepository extends Repository<User, Long>
{
	public User save(User user);
	public void delete(User user);
	public long count();
	public User findByIdIn(Integer id);
	public List<User> findAll();
	public User findTopByUserNameInAndPasswordIn(String userName, String password);
}