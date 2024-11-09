package co.com.munamu.munamuinventory.controller.response.concrete;

import java.util.List;
import co.com.munamu.munamuinventory.controller.response.ResponseWithData;
import co.com.munamu.munamuinventory.controller.response.Response;
import co.com.munamu.munamuinventory.dto.CategoryDTO;

public class CategoryResponse extends ResponseWithData<CategoryDTO>{
	
	public static final Response build(final List<String> messages,  final List<CategoryDTO> data) {
		var response = new CategoryResponse();
		response.setMessages(messages);
		response.setData(data);
		return response;
	}

}
