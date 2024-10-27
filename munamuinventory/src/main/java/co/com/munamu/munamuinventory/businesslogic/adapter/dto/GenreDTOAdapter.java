package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.dto.GenreDTO;


public class GenreDTOAdapter implements Adapter<GenreDomain,GenreDTO> {
	
	private static final Adapter<GenreDomain,GenreDTO> instance = new GenreDTOAdapter();
	
	private GenreDTOAdapter() {
		
	}
	
	public static Adapter<GenreDomain,GenreDTO> getGenreDTOAdapter(){
		return instance;
	}
	
		 @Override
		    public GenreDomain adaptSource(final GenreDTO data) {
			 return null;
		    }

		    @Override
		    public GenreDTO adaptTarget(final GenreDomain data) {
		    	return null;
		    
	}
}
