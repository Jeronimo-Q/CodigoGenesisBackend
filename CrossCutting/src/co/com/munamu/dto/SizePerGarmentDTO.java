package co.com.munamu.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizePerGarmentDTO extends DomainDTO{
	
	private SizeDTO size;
	private GarmentDTO garmnet;
	
	public SizePerGarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGarmnet(GarmentDTO.create());
		setSize(SizeDTO.create());
	}
	
	public static final SizePerGarmentDTO create() {
		return new SizePerGarmentDTO();
	}	

	public SizeDTO getSize() {
		return size;
	}

	public SizePerGarmentDTO setSize(SizeDTO size) {
		this.size = ObjectHelper.getDefault(size, SizeDTO.create());
		return this;
	}

	public GarmentDTO getGarmnet() {
		return garmnet;
	}

	public SizePerGarmentDTO setGarmnet(GarmentDTO garmnet) {
		this.garmnet = ObjectHelper.getDefault(garmnet, GarmentDTO.create());
		return this;
	}

	public SizePerGarmentDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
}
