package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
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
		 return null;
	    }

	    @Override
	    public SizePerGarmentDTO adaptTarget(final SizePerGarmentDomain data) {
	    	return null;
	    
}
}
