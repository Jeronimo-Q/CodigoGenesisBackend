package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;


public final class TypeGarmentDTOAdapter implements Adapter<TypeGarmentDomain,TypeGarmentDTO> {
	private static final Adapter<TypeGarmentDomain,TypeGarmentDTO> instance = new TypeGarmentDTOAdapter();
	
	private TypeGarmentDTOAdapter() {
		
	}
	
	public static Adapter<TypeGarmentDomain,TypeGarmentDTO> getTypeGarmentDTOAdapter(){
		return instance;
	}	
	 @Override
	    public TypeGarmentDomain adaptTarjet(final TypeGarmentDTO data) {
			var dtoToAdapt=ObjectHelper.getDefault(data,TypeGarmentDTO.create());
			return TypeGarmentDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getName());
	    }

	    @Override
	    public TypeGarmentDTO adaptSource(final TypeGarmentDomain data) {
			var domainToAdapt=ObjectHelper.getDefault(data,TypeGarmentDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
			
			return TypeGarmentDTO.create().setId(domainToAdapt.getId().toString()).setName(domainToAdapt.getName());
	    
}

		@Override
		public List<TypeGarmentDTO> adaptSource(List<TypeGarmentDomain> data) {
			var results = new ArrayList<TypeGarmentDTO>();
			
			for (TypeGarmentDomain domain:data) {
				results.add(adaptSource(domain));
			}
			
			return results;
		}

		@Override
		public List<TypeGarmentDomain> adaptTarjet(List<TypeGarmentDTO> data) {
			var results = new ArrayList<TypeGarmentDomain>();
			
			for (TypeGarmentDTO entity:data) {
				results.add(adaptTarjet(entity));
			}
			
			return results;
		}
}
