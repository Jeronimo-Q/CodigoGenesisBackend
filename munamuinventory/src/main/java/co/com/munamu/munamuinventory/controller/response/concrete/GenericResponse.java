package co.com.munamu.munamuinventory.controller.response.concrete;

import java.util.List;

import co.com.munamu.munamuinventory.controller.response.Response;

public class GenericResponse extends Response{
	
	public static final Response build(final List<String> messages) {
		var response = new GenericResponse();
		response.setMessages(messages);
		return response;
	}

}
