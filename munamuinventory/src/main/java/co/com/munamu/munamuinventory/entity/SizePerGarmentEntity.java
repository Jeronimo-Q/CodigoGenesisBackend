package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizePerGarmentEntity extends DomainEntity{
	
	private SizeEntity size;
	private GarmentEntity garment;
	
	public SizePerGarmentEntity() {
		super(UUIDHelper.getDefault());
		setGarment(GarmentEntity.create());
		setSize(SizeEntity.create());
	}
	
	public static final SizePerGarmentEntity create() {
		return new SizePerGarmentEntity();
	}	

	public SizeEntity getSize() {
		return size;
	}

	public SizePerGarmentEntity setSize(SizeEntity size) {
		this.size = ObjectHelper.getDefault(size, SizeEntity.create());
		return this;
	}

	public GarmentEntity getGarment() {
		return garment;
	}

	public SizePerGarmentEntity setGarment(GarmentEntity garmnet) {
		this.garment = ObjectHelper.getDefault(garmnet, GarmentEntity.create());
		return this;
	}

	@Override
	public void setId(final UUID id) {
		super.setId(id);
	
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
