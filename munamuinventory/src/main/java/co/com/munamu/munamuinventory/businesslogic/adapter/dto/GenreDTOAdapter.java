package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.dto.GenreDTO;

public class GenreDTOAdapter implements Adapter<GenreDomain,GenreDTO> {
	
		 @Override
		    public GenreDomain adaptSource(final GenreDTO data) {
			 return null;
		    }

		    @Override
		    public GenreDTO adaptTarget(final GenreDomain data) {
		    	return null;
		    
	}
}
