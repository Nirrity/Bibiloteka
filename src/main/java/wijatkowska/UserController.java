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

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
	
	
    @PostMapping("/register")
    public String registerSubmit(@ModelAttribute User user) {
    	User ret = userRepository.save(user);
    	if(ret != null){
    		return "login";
    	}
    	return "error";
    }
	

	@PostMapping("/login")
    public String loginSubmit(HttpServletResponse response,
    @ModelAttribute User user, Model model) {
    	User userInDb = userRepository.findTopByUserNameInAndPasswordIn(user.getUserName(),user.getPassword());
    	if(userInDb != null){
           
            Cookie cookie = new Cookie("userId", Integer.toString(userInDb.getId()));
            cookie.setMaxAge(1200);
            		
            response.addCookie(cookie);
    		return "wypozyczalnia";
    	}
        return "login";
    }
	
	
    @GetMapping("/login")
    public String getLogin(HttpServletRequest req, 
        @CookieValue(value = "userId", defaultValue = "-1") String userId, Model model){
			if(userId.equals("-1")){
            model.addAttribute("user", new User());
            return "login";           
        } else {
        	User user = userRepository.findByIdIn(Integer.parseInt(userId));
            model.addAttribute("user", user);
            return "wypozyczalnia";
        }
	}    
}
