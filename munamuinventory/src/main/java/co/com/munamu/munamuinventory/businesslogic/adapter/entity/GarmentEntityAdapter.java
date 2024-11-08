package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.GarmentEntity;

public final class GarmentEntityAdapter implements Adapter<GarmentDomain,GarmentEntity> {
	private static final Adapter<GarmentDomain,GarmentEntity> instance = new GarmentEntityAdapter();
	
	private GarmentEntityAdapter() {
		
	}
	
	public static Adapter<GarmentDomain,GarmentEntity> getGarmentEntityAdapter(){
		return instance;
	}
	
	
	@Override
	public GarmentDomain adaptTarjet(final GarmentEntity data) {
	    var entityToAdapt = ObjectHelper.getDefault(data, GarmentEntity.create());

	    GarmentConfigurationDomain garmentConfigurationDomain = 
	        GarmentConfigurationEntityAdapter.getGarmentConfigurationEntityAdapter().adaptTarjet(entityToAdapt.getGarmentConfiguration());
	    
	    
	    return GarmentDomain.create(  
	        UUIDHelper.convertToUUID(entityToAdapt.getId()),
	        garmentConfigurationDomain,
	        entityToAdapt.getDescription(),
	        entityToAdapt.getReference()
	    );
	}
	
	@Override
	public GarmentEntity adaptSource(final GarmentDomain data) {
	    var domainToAdapt = ObjectHelper.getDefault(data, GarmentDomain.create(
	    		UUIDHelper.getDefault(),
	    		GarmentConfigurationDomain.create(UUIDHelper.getDefault(),
	    				CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
	    				GenreDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
	    				TypeGarmentDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY)),
	    		TextHelper.EMPTY,
	    		TextHelper.EMPTY));

	    GarmentConfigurationEntity garmentConfigurationEntity = 
	    		GarmentConfigurationEntityAdapter.getGarmentConfigurationEntityAdapter().adaptSource(domainToAdapt.getGarmentConfiguration());
	    
	    var entityAdapted = new GarmentEntity();
	    entityAdapted.setId(domainToAdapt.getId());
	    entityAdapted.setReference(domainToAdapt.getReference());
	    entityAdapted.setDescription(domainToAdapt.getDescription());
	    entityAdapted.setGarmentConfiguration(garmentConfigurationEntity);
	    
	    return entityAdapted;
	}

	@Override
	public List<GarmentEntity> adaptSource(List<GarmentDomain> data) {
		var results = new ArrayList<GarmentEntity>();
		
		for (GarmentDomain domain:data) {
			results.add(adaptSource(domain));
		}
		
		return results;
	}

	@Override
	public List<GarmentDomain> adaptTarjet(List<GarmentEntity> data) {
		var results = new ArrayList<GarmentDomain>();
		
		for (GarmentEntity entity:data) {
			results.add(adaptTarjet(entity));
		}
		
		return results;
	}



}


