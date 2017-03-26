package wijatkowska;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/wypozyczalnia")
    public String registerForm(Model model) {
        model.addAttribute("bookList", bookRepository.findAll());
        

        return "wypozyczalnia";
    }

    @GetMapping("/rent")
    public String rent(HttpServletRequest req, HttpServletResponse resp, 
                    @CookieValue(value = "userId", defaultValue = "-1") String userId,
                    @RequestParam("id") String bookId, Model model) {

        if(userId.equals("-1")){
            model.addAttribute("user", new User());
            return "login";           
        }

        Book book = bookRepository.findByIdIn(Integer.parseInt(bookId));
        
        System.out.println(Integer.parseInt(userId));
        book.setRentById(Integer.parseInt(userId));

        Book ret = bookRepository.save(book);
        System.out.println(book.getRentById() + " " + ret.getRentById());

        return registerForm(model);
    }
    
}
