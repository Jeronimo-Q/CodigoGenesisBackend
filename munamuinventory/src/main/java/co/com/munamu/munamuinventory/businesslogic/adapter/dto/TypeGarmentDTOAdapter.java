package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;

public class TypeGarmentDTOAdapter implements Adapter<TypeGarmentDomain,TypeGarmentDTO> {
	
	 @Override
	    public TypeGarmentDomain adaptSource(final TypeGarmentDTO data) {
		 return null;
	    }

	    @Override
	    public TypeGarmentDTO adaptTarget(final TypeGarmentDomain data) {
	    	return null;
	    
}
}
