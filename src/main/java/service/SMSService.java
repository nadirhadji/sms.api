package service;

import com.twilio.rest.api.v2010.account.Message;

public interface SMSService {
	
	public Message sendSMS();

	Message sendSMS(String sid, String token, String from, String to, String message);

}

