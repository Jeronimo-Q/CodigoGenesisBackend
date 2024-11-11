package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

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
	public GarmentDomain adaptTarjet(final GarmentDTO data) {
	    var dtoToAdapt = ObjectHelper.getDefault(data, GarmentDTO.create());

	    GarmentConfigurationDomain garmentConfigurationDomain = 
	        GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptTarjet(dtoToAdapt.getGarmentConfiguration());
	    
	    
	    return GarmentDomain.create(  
	        UUIDHelper.convertToUUID(dtoToAdapt.getId()),
	        garmentConfigurationDomain,
	        dtoToAdapt.getDescription(),
	        dtoToAdapt.getReference()
	    );
	}

	@Override
	public GarmentDTO adaptSource(final GarmentDomain data) {
		    var domainToAdapt = ObjectHelper.getDefault(data, GarmentDomain.create(
		    		UUIDHelper.getDefault(),
		    		GarmentConfigurationDomain.create(UUIDHelper.getDefault(),
		    				CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
		    				GenreDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY),
		    				TypeGarmentDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY)),
		    		TextHelper.EMPTY,
		    		TextHelper.EMPTY));

		    GarmentConfigurationDTO garmentConfigurationDTO = 
		    		GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptSource(domainToAdapt.getGarmentConfiguration());

		    return GarmentDTO.create().setId(domainToAdapt.getId().toString()).setGarmentConfiguration(garmentConfigurationDTO);

	}

	@Override
	public List<GarmentDTO> adaptSource(List<GarmentDomain> data) {
		var results = new ArrayList<GarmentDTO>();
		
		for (GarmentDomain domain:data) {
			results.add(adaptSource(domain));
		}
		
		return results;
	}

	@Override
	public List<GarmentDomain> adaptTarjet(List<GarmentDTO> data) {
		var results = new ArrayList<GarmentDomain>();
		
		for (GarmentDTO entity:data) {
			results.add(adaptTarjet(entity));
		}
		
		return results;
	}
	    
}
	

	
	
	



 
	
	
	

