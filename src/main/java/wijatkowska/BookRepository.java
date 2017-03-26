package wijatkowska;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.repository.Repository;

@Transactional
public interface BookRepository extends Repository<Book, Long>
{
	public Book save(Book book);
	public void delete(Book book);
	public long count();
	public Book findByIdIn(Integer id);
	public List<Book> findAll();
	public Book findTopByTitleInAndAuthorsIn(String title, String authors);
}