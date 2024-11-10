package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.dto.GenreDTO;


public final class GenreDTOAdapter implements Adapter<GenreDomain,GenreDTO> {
	
	private static final Adapter<GenreDomain,GenreDTO> instance = new GenreDTOAdapter();
	
	private GenreDTOAdapter() {
		
	}
	
	public static Adapter<GenreDomain,GenreDTO> getGenreDTOAdapter(){
		return instance;
	}
	
		 @Override
		    public GenreDomain adaptTarjet(final GenreDTO data) {
				var dtoToAdapt=ObjectHelper.getDefault(data,GenreDTO.create());
				return GenreDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getName());
		    }

		    @Override
		    public GenreDTO adaptSource(final GenreDomain data) {
				var domainToAdapt=ObjectHelper.getDefault(data,GenreDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
				//return GenreDTO.create().setId(TextHelper.EMPTY).setName(domainToAdapt.getName());
				return GenreDTO.create().setId(domainToAdapt.getId().toString()).setName(data.getName());
		    
	}

			@Override
			public List<GenreDTO> adaptSource(List<GenreDomain> data) {
				var results = new ArrayList<GenreDTO>();
				
				for (GenreDomain domain:data) {
					results.add(adaptSource(domain));
				}
				
				return results;
			}

			@Override
			public List<GenreDomain> adaptTarjet(List<GenreDTO> data) {
				var results = new ArrayList<GenreDomain>();
				
				for (GenreDTO entity:data) {
					results.add(adaptTarjet(entity));
				}
				
				return results;
			}
}
