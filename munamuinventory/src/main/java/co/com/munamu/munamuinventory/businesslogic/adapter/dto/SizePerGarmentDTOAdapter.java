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
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.GarmentDTO;
import co.com.munamu.munamuinventory.dto.SizeDTO;
import co.com.munamu.munamuinventory.dto.SizePerGarmentDTO;

public final class SizePerGarmentDTOAdapter implements Adapter<SizePerGarmentDomain,SizePerGarmentDTO> {
	 
	private static final Adapter<SizePerGarmentDomain,SizePerGarmentDTO> instance = new SizePerGarmentDTOAdapter();
	
	private SizePerGarmentDTOAdapter() {
	}

	public static Adapter<SizePerGarmentDomain,SizePerGarmentDTO> getSizePerGarmentDTOAdapter(){
		return instance;
	}
	
	@Override
	public SizePerGarmentDomain adaptTarjet(final SizePerGarmentDTO data) {
		var dtoToAdapt = ObjectHelper.getDefault(data, SizePerGarmentDTO.create());
		
		 GarmentDomain garmentDomain = 
		            GarmentDTOAdapter.getGarmentDTOAdapter().adaptTarjet(dtoToAdapt.getGarment());
		    
		    SizeDomain sizeDomain = 
		            SizeDTOAdapter.getSizeDTOAdapter().adaptTarjet(dtoToAdapt.getSize());
		
		return SizePerGarmentDomain.create(  
		        UUIDHelper.convertToUUID(dtoToAdapt.getId()),
		        sizeDomain,
		        garmentDomain);
	}

	@Override
	public SizePerGarmentDTO adaptSource(final SizePerGarmentDomain data) {
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

	    SizeDTO sizeDTO = SizeDTOAdapter.getSizeDTOAdapter().adaptSource(domainToAdapt.getSize());
	    
	    GarmentDTO garmentDTO = GarmentDTOAdapter.getGarmentDTOAdapter().adaptSource(domainToAdapt.getGarment());

	    return SizePerGarmentDTO.create().setId(TextHelper.EMPTY).setSize(sizeDTO).setGarment(garmentDTO);
	}

	@Override
	public List<SizePerGarmentDTO> adaptSource(List<SizePerGarmentDomain> data) {
		var results = new ArrayList<SizePerGarmentDTO>();
		
		for (SizePerGarmentDomain domain:data) {
			results.add(adaptSource(domain));
		}
		
		return results;
	}

	@Override
	public List<SizePerGarmentDomain> adaptTarjet(List<SizePerGarmentDTO> data) {
		var results = new ArrayList<SizePerGarmentDomain>();
		
		for (SizePerGarmentDTO entity:data) {
			results.add(adaptTarjet(entity));
		}
		
		return results;
	}



}
