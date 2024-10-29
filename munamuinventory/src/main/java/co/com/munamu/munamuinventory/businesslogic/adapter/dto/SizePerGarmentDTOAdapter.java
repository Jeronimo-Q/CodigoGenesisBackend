package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
import co.com.munamu.munamuinventory.dto.CategoryDTO;
import co.com.munamu.munamuinventory.dto.GarmentDTO;
import co.com.munamu.munamuinventory.dto.SizePerGarmentDTO;

public class SizePerGarmentDTOAdapter implements Adapter<SizePerGarmentDomain,SizePerGarmentDTO> {
	 
	private static final Adapter<SizePerGarmentDomain,SizePerGarmentDTO> instance = new SizePerGarmentDTOAdapter();
	
	private SizePerGarmentDTOAdapter() {
		
	}
	
	public static Adapter<SizePerGarmentDomain,SizePerGarmentDTO> getSizePerGarmentEntityAdapter(){
		return instance;
	}
	
	@Override
		public SizePerGarmentDomain adaptSource(final SizePerGarmentDTO data) {
	    var dtoToAdapt = ObjectHelper.getDefault(data, SizePerGarmentDTO.create());

	    SizePerGarmentDomain SizePerGarmentDomain = 
	    		SizePerGarmentDTOAdapter.SizePerGarmentEntityAdapter()
	            .adaptSource(dtoToAdapt.getSizePerGarment());
		
	    }

	    @Override
	    public SizePerGarmentDTO adaptTarget(final SizePerGarmentDomain data) {
	    	return null;
	    
}
}
