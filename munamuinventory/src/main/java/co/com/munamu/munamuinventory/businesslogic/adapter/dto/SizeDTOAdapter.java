package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.dto.SizeDTO;

public class SizeDTOAdapter implements Adapter<SizeDomain,SizeDTO> {
	
	private static final Adapter<SizeDomain,SizeDTO> instance = new SizeDTOAdapter();
	
	private SizeDTOAdapter() {
		
	}
	public static Adapter<SizeDomain,SizeDTO> getSizeDTOAdapter(){
		return instance;
	}
	
	@Override
	    public SizeDomain adaptSource(final SizeDTO data) {
		 return null;
	    }

	    @Override
	    public SizeDTO adaptTarget(final SizeDomain data) {
	    	return null;
	    
}
}
