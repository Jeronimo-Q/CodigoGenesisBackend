package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.dto.GarmentDTO;

public class GarmentDTOAdapter implements Adapter<GarmentDomain,GarmentDTO> {
	 
	private static final Adapter<GarmentDomain,GarmentDTO> instance = new GarmentDTOAdapter();
	
	private GarmentDTOAdapter() {
		
	}
	
	public static Adapter<GarmentDomain,GarmentDTO> getGarmentDTOAdapter(){
		return instance;
	}
	@Override
	    public GarmentDomain adaptSource(final GarmentDTO data) {
		 return null;
	    }

	    @Override
	    public GarmentDTO adaptTarget(final GarmentDomain data) {
	    	return null;
	    }
}
