package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.entity.GarmentEntity;
import co.com.munamu.munamuinventory.entity.SizeEntity;
import co.com.munamu.munamuinventory.entity.SizePerGarmentEntity;

public final class SizePerGarmentEntityAdapter implements Adapter<SizePerGarmentDomain,SizePerGarmentEntity> {
	
	private static final Adapter<SizePerGarmentDomain,SizePerGarmentEntity> instance = new SizePerGarmentEntityAdapter();
	
	private SizePerGarmentEntityAdapter() {
		
	}
	
	public static Adapter<SizePerGarmentDomain,SizePerGarmentEntity> getSizePerGarmentEntityAdapter(){
		return instance;
	}
	
	@Override
	public SizePerGarmentDomain adaptTarjet(final SizePerGarmentEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data, SizePerGarmentEntity.create());
		
		 GarmentDomain garmentDomain = 
		            GarmentEntityAdapter.getGarmentEntityAdapter().adaptTarjet(entityToAdapt.getGarment());
		    
		    SizeDomain sizeDomain = 
		            SizeEntityAdapter.getSizeEntityAdapter().adaptTarjet(entityToAdapt.getSize());
		
		return SizePerGarmentDomain.create(  
		        UUIDHelper.convertToUUID(entityToAdapt.getId()),
		        sizeDomain,
		        garmentDomain
		    );
	}
	@Override
	public SizePerGarmentEntity adaptSource(final SizePerGarmentDomain data) {
		
	    var domainToAdapt = ObjectHelper.getDefault(
		        data, 
		        SizePerGarmentDomain.create(
		            UUIDHelper.getDefault(),
		            SizeDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY),
		            GarmentDomain.create(UUIDHelper.getDefault(), GarmentConfigurationDomain.create(UUIDHelper.getDefault(), 
		                CategoryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
		                GenreDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
		                TypeGarmentDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY)),
		                TextHelper.EMPTY, TextHelper.EMPTY)
		        )
		    );

		    SizeEntity sizeEntity = SizeEntityAdapter.getSizeEntityAdapter().adaptSource(domainToAdapt.getSize());
		    
		    GarmentEntity garmentEntity = GarmentEntityAdapter.getGarmentEntityAdapter().adaptSource(domainToAdapt.getGarment());
		    
		    var entityAdapted = new SizePerGarmentEntity();
		    entityAdapted.setId(domainToAdapt.getId());
		    entityAdapted.setGarment(garmentEntity);
		    entityAdapted.setSize(sizeEntity);
		    
		return entityAdapted;
	}
}


