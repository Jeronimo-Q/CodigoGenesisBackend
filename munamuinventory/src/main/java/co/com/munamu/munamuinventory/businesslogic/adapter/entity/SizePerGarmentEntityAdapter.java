package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
import co.com.munamu.munamuinventory.entity.SizePerGarmentEntity;

public class SizePerGarmentEntityAdapter implements Adapter<SizePerGarmentDomain,SizePerGarmentEntity> {
	
	private static final Adapter<SizePerGarmentDomain,SizePerGarmentEntity> instance = new SizePerGarmentEntityAdapter();
	
	private SizePerGarmentEntityAdapter() {
		
	}
	
	public static Adapter<SizePerGarmentDomain,SizePerGarmentEntity> getSizePerGarmentEntityAdapter(){
		return instance;
	}
	
	@Override
	public SizePerGarmentDomain adaptSource(final SizePerGarmentEntity data) {
		return null;
	}
	
	@Override
	public SizePerGarmentEntity adaptTarget(final SizePerGarmentDomain data) {
		return null;
	}
}


