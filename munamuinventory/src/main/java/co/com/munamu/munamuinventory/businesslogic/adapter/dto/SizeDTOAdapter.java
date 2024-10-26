package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.dto.SizeDTO;

public class SizeDTOAdapter implements Adapter<SizeDomain,SizeDTO> {
	 @Override
	    public SizeDomain adaptSource(final SizeDTO data) {
		 return null;
	    }

	    @Override
	    public SizeDTO adaptTarget(final SizeDomain data) {
	    	return null;
	    
}
}
