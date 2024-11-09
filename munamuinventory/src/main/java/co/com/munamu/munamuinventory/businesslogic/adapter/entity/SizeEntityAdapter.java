package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.entity.SizeEntity;

public final class SizeEntityAdapter implements Adapter<SizeDomain,SizeEntity> {
	private static final Adapter<SizeDomain,SizeEntity> instance = new SizeEntityAdapter();
	
	private SizeEntityAdapter() {
		
	}
	public static Adapter<SizeDomain,SizeEntity> getSizeEntityAdapter(){
		return instance;
	}
	
	@Override
	public SizeDomain adaptTarjet(final SizeEntity data) {
		var entityToAdapt=ObjectHelper.getDefault(data,SizeEntity.create());
		return SizeDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public SizeEntity adaptSource(final SizeDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				SizeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new SizeEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}
	@Override
	public List<SizeEntity> adaptSource(List<SizeDomain> data) {
		var results = new ArrayList<SizeEntity>();
		
		for (SizeDomain domain:data) {
			results.add(adaptSource(domain));
		}
		
		return results;
	}
	@Override
	public List<SizeDomain> adaptTarjet(List<SizeEntity> data) {
		var results = new ArrayList<SizeDomain>();
		
		for (SizeEntity entity:data) {
			results.add(adaptTarjet(entity));
		}
		
		return results;
	}
}


