package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizePerGarmentDomain extends Domain{
	
	private SizeDomain size;
	private GarmentDomain garment;
	
	private SizePerGarmentDomain(final UUID id,final SizeDomain size,final GarmentDomain garment ) {
		super (id);
		setSize(size);
		setGarment(garment);
	}
	
	public static SizePerGarmentDomain create(final UUID id,final SizeDomain size,final GarmentDomain garment ) {
		return new SizePerGarmentDomain(id, size, garment);
	}
	
	static final SizePerGarmentDomain create() {
		return new SizePerGarmentDomain(UUIDHelper.getDefault(),SizeDomain.create(), GarmentDomain.create());
	}
	
	public SizeDomain getSize() {
		return size;
	}

	private void setSize(SizeDomain size) {
		this.size = ObjectHelper.getDefault(size, SizeDomain.create());
	}

	public GarmentDomain getGarment() {
		return garment;
	}

	private void setGarment(GarmentDomain garment) {
		this.garment = ObjectHelper.getDefault(garment, GarmentDomain.create());
	}

	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
