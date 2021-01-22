package service;


import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


@Service
public class SMSServiceTwilio implements SMSService {
	
	public Message sendSMS(String sid, String token, String from, String to ,String texto) {
		
		Twilio.init(sid, token);
		
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber(from),
                texto)
           .create();

        return message;
	}
	
	public String phoneNumberFormator() {
		//TODO
		return null;
	}
	
	public String test() {
		return "test";
	}

	@Override
	public Message sendSMS() {
		// TODO Auto-generated method stub
		return null;
	}

}
