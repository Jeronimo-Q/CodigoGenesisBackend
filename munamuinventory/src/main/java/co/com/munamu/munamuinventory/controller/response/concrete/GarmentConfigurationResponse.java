package co.com.munamu.munamuinventory.controller.response.concrete;

import java.util.List;
import co.com.munamu.munamuinventory.controller.response.ResponseWithData;
import co.com.munamu.munamuinventory.controller.response.Response;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;

public class GarmentConfigurationResponse extends ResponseWithData<GarmentConfigurationDTO>{
	
	public static final Response build(final List<String> messages,  final List<GarmentConfigurationDTO> data) {
		var response = new GarmentConfigurationResponse();
		response.setMessages(messages);
		response.setData(data);
		return response;
	}

}
