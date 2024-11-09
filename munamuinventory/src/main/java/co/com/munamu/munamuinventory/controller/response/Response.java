package co.com.munamu.munamuinventory.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;

public abstract class Response {
	
	private List<String> messages = new ArrayList<>();

	public final List<String> getMessages() {
		return messages;
	}

	public  void setMessages(List<String> messages) {
		this.messages = ObjectHelper.getDefault(messages, this.messages);
	}
	
}
