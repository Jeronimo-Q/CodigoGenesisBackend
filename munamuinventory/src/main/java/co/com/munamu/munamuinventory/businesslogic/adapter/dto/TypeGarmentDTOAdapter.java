package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;


public class TypeGarmentDTOAdapter implements Adapter<TypeGarmentDomain,TypeGarmentDTO> {
	private static final Adapter<TypeGarmentDomain,TypeGarmentDTO> instance = new TypeGarmentDTOAdapter();
	
	private TypeGarmentDTOAdapter() {
		
	}
	
	public static Adapter<TypeGarmentDomain,TypeGarmentDTO> getTypeGarmentDTOAdapter(){
		return instance;
	}	
	 @Override
	    public TypeGarmentDomain adaptSource(final TypeGarmentDTO data) {
		 return null;
	    }

	    @Override
	    public TypeGarmentDTO adaptTarget(final TypeGarmentDomain data) {
	    	return null;
	    
}
}
