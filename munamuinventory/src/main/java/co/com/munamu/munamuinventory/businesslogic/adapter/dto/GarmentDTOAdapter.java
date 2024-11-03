package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;
import co.com.munamu.munamuinventory.dto.GarmentDTO;



public final class GarmentDTOAdapter implements Adapter<GarmentDomain,GarmentDTO> {
	 
	private static final Adapter<GarmentDomain,GarmentDTO> instance = new GarmentDTOAdapter();
	
	private GarmentDTOAdapter() {
		
	}
	
	public static Adapter<GarmentDomain,GarmentDTO> getGarmentDTOAdapter(){
		return instance;
	}
	
	@Override
	public GarmentDomain adaptSource(final GarmentDTO data) {
	    var dtoToAdapt = ObjectHelper.getDefault(data, GarmentDTO.create());

	    GarmentConfigurationDomain garmentConfigurationDomain = 
	        GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptSource(dtoToAdapt.getGarmentConfiguration());
	    
	    
	    return GarmentDomain.create(  
	        UUIDHelper.convertToUUID(dtoToAdapt.getId()),
	        garmentConfigurationDomain,
	        dtoToAdapt.getDescription(),
	        dtoToAdapt.getReference()
	    );
	}

	@Override
	public GarmentDTO adaptTarget(final GarmentDomain data) {
		    var domainToAdapt = ObjectHelper.getDefault(data, GarmentDomain.create(
		    		UUIDHelper.getDefault(),
		    		GarmentConfigurationDomain.create(UUIDHelper.getDefault(),
		    				CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
		    				GenreDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
		    				TypeGarmentDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY)),
		    		TextHelper.EMPTY,
		    		TextHelper.EMPTY));

		    GarmentConfigurationDTO garmentConfigurationDTO = 
		    		GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptTarget(domainToAdapt.getGarmentConfiguration());

		    return GarmentDTO.create().setId("").setGarmentConfiguration(garmentConfigurationDTO);

	}
	    
}
	

	
	
	



 
	
	
	

