package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.SizeEntity;

public class SizeEntityAdapter implements Adapter<SizeDomain,SizeEntity> {
	private static final Adapter<SizeDomain,SizeEntity> instance = new SizeEntityAdapter();
	
	private SizeEntityAdapter() {
		
	}
	public static Adapter<SizeDomain,SizeEntity> getSizeEntityAdapter(){
		return instance;
	}
	
	@Override
	public SizeDomain adaptSource(final SizeEntity data) {
		return null;
	}
	
	@Override
	public SizeEntity adaptTarget(final SizeDomain data) {
		return null;
	}
}


