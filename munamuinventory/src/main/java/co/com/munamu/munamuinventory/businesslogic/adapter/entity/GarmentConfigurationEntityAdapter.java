package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.entity.CategoryEntity;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;

public class GarmentConfigurationEntityAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> {
	private static final Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> instance = new GarmentConfigurationEntityAdapter();
	
	private GarmentConfigurationEntityAdapter() {
		
	}
	
	public static Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> getGarmentConfigurationEntityAdapter(){
		return instance;
	}
	
	@Override
	public GarmentConfigurationDomain adaptSource(final GarmentConfigurationEntity data) {
		return null;
	}
	
	@Override
	public GarmentConfigurationEntity adaptTarget(final GarmentConfigurationDomain data) {
		return null;
	}
}


