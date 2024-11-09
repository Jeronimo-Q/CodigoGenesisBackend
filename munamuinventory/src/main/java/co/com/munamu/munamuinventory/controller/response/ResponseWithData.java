package co.com.munamu.munamuinventory.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;

public class ResponseWithData <T> extends Response{
	
	private List<T> data = new ArrayList<>();

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = ObjectHelper.getDefault(data, this.data);
	}
	
	

}
