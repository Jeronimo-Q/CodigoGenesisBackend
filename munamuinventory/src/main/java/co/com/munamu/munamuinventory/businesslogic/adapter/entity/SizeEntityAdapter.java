package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.entity.CategoryEntity;
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
		var entityToAdapt=ObjectHelper.getDefault(data,SizeEntity.create());
		return SizeDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public SizeEntity adaptTarget(final SizeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				SizeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new SizeEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}
}


