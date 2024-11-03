package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.dto.CategoryDTO;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;
import co.com.munamu.munamuinventory.dto.GenreDTO;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;


public final class GarmentConfigurationDTOAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> {
	private static final Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> instance = new GarmentConfigurationDTOAdapter();
	
	private GarmentConfigurationDTOAdapter() {
		
	}
	
	public static Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> getGarmentConfigurationDTOAdapter(){
		return instance;
	}

	
	@Override
	public GarmentConfigurationDomain adaptSource(final GarmentConfigurationDTO data) {
	    var dtoToAdapt = ObjectHelper.getDefault(data, GarmentConfigurationDTO.create());

	   
	    CategoryDomain categoryDomain = CategoryDTOAdapter.getCategoryDTOAdapter().adaptSource(dtoToAdapt.getCategory());

	    GenreDomain genreDomain = GenreDTOAdapter.getGenreDTOAdapter().adaptSource(dtoToAdapt.getGenre());

	    TypeGarmentDomain typeGarmentDomain = TypeGarmentDTOAdapter.getTypeGarmentDTOAdapter().adaptSource(dtoToAdapt.getTypeGarment());

	    return GarmentConfigurationDomain.create(
	        UUIDHelper.convertToUUID(dtoToAdapt.getId()),
	        categoryDomain,
	        genreDomain,
	        typeGarmentDomain
	    );
	}
	
	@Override
	public GarmentConfigurationDTO adaptTarget(final GarmentConfigurationDomain data) {
		
		var domainToAdapt = ObjectHelper.getDefault(data, GarmentConfigurationDomain.create(UUIDHelper.getDefault(),
				CategoryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
				GenreDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
				TypeGarmentDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY)));
		
		CategoryDTO categoryDTO = CategoryDTOAdapter.getCategoryDTOAdapter().adaptTarget(domainToAdapt.getCategory());
		
		GenreDTO genreDTO = GenreDTOAdapter.getGenreDTOAdapter().adaptTarget(domainToAdapt.getGenre());
		
		TypeGarmentDTO typeGarmentDTO = TypeGarmentDTOAdapter.getTypeGarmentDTOAdapter().adaptTarget(domainToAdapt.getTypeGarment());
		
	    return GarmentConfigurationDTO.create().setId("").setCategory(categoryDTO).setGenre(genreDTO).setTypeGarment(typeGarmentDTO);

	}


	
}

  



