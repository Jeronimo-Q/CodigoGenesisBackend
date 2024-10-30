package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizePerGarmentDTO extends DomainDTO{
	
	private SizeDTO size;
	private GarmentDTO garmnet;
	
	public SizePerGarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGarment(GarmentDTO.create());
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

	public GarmentDTO getGarment() {
		return garmnet;
	}

	public SizePerGarmentDTO setGarment(GarmentDTO garmnet) {
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
