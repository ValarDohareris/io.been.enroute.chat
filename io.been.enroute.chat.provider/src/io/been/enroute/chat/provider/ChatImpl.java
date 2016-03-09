package io.been.enroute.chat.provider;

import org.osgi.service.component.annotations.Component;

import io.been.enroute.chat.api.Chat;
import io.been.enroute.chat.api.Message;

/**
 * servicereferences io.been.enroute.chat.api.Chat null
 */
@Component(
		name = "io.been.enroute.chat", 
		property = "user.name=osgi"
)
public class ChatImpl implements Chat {

	@Override
	public boolean send(Message message) throws Exception {
		
		System.out.printf("%s: %s%n", message.from, message.text);
		return true;
	}

}
