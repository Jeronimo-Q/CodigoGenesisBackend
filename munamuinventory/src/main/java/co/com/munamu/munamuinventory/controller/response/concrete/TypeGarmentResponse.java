package co.com.munamu.munamuinventory.controller.response.concrete;

import java.util.List;
import co.com.munamu.munamuinventory.controller.response.ResponseWithData;
import co.com.munamu.munamuinventory.controller.response.Response;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;

public class TypeGarmentResponse extends ResponseWithData<TypeGarmentDTO>{
	
	public static final Response build(final List<String> messages,  final List<TypeGarmentDTO> data) {
		var response = new TypeGarmentResponse();
		response.setMessages(messages);
		response.setData(data);
		return response;
	}

}
