package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.twilio.exception.TwilioException;

import entity.Numbers;
import entity.Session;
import repository.NumbersRepository;
import service.SMSServiceTwilio;

@Controller
public class WelcomeController {
	
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;
        
    @Autowired
    NumbersRepository repo;
    
    @Autowired
    SMSServiceTwilio sms;
        

    @GetMapping("/")
    public String welcome(Session session) {
    	    	
        return "welcome"; //view
    } 
    
    @RequestMapping(value="/submit", method = RequestMethod.POST) 
	public ModelAndView submit( Session session) {
    	System.out.println(session.getPhonenumber());
    	
    	
    	try {
    		
    		for ( int i = 0 ; i < 100 ; i++) {
    			
    			for (Numbers item : repo.findAll()) {
    	    		
            		sms.sendSMS(session.getSid(), session.getAuthToken(), session.getPhonenumber(), item.getPhonenumber(), session.getMessage());
        		}
    		}
    		
    		
    	} catch(TwilioException e) {
    		e.printStackTrace();
    	}
    	
    	
    	return new ModelAndView("after-submission","sess",session);
	}
    
    @RequestMapping(value="/repo") 
    public String receivers(Model model) {
    	model.addAttribute("phonelist",repo.findAll());
    	return "phonelist";
    }
    
    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(	
            @RequestParam(name = "name", required = false, defaultValue = "") 
			String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }
    
}
