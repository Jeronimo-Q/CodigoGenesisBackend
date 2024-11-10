package co.com.munamu.munamuinventory.controller.response.concrete;

import java.util.List;
import co.com.munamu.munamuinventory.controller.response.ResponseWithData;
import co.com.munamu.munamuinventory.controller.response.Response;
import co.com.munamu.munamuinventory.dto.GenreDTO;

public class GenreResponse extends ResponseWithData<GenreDTO>{
	
	public static final Response build(final List<String> messages,  final List<GenreDTO> data) {
		var response = new GenreResponse();
		response.setMessages(messages);
		response.setData(data);
		return response;
	}

}
