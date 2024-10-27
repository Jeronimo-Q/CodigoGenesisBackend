package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.GarmentEntity;

public class GarmentEntityAdapter implements Adapter<GarmentDomain,GarmentEntity> {
	private static final Adapter<GarmentDomain,GarmentEntity> instance = new GarmentEntityAdapter();
	
	private GarmentEntityAdapter() {
		
	}
	
	public static Adapter<GarmentDomain,GarmentEntity> getGarmentEntityAdapter(){
		return instance;
	}
	
	
	@Override
	public GarmentDomain adaptSource(final GarmentEntity data) {
		return null;
	}
	
	@Override
	public GarmentEntity adaptTarget(final GarmentDomain data) {
		return null;
	}
}


