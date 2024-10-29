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


public class GarmentConfigurationDTOAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> {
	private static final Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> instance = new GarmentConfigurationDTOAdapter();
	
	private GarmentConfigurationDTOAdapter() {
		
	}
	
	public static Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> getGarmentConfigurationEntityAdapter(){
		return instance;
	}

	
	@Override
	public GarmentConfigurationDomain adaptSource(final GarmentConfigurationDTO data) {
	    var dtoToAdapt = ObjectHelper.getDefault(data, GarmentConfigurationDTO.create());

	   
	    CategoryDomain categoryDomain = CategoryDomain.create(
	        UUIDHelper.convertToUUID(dtoToAdapt.getCategory().getId()),
	        dtoToAdapt.getCategory().getName() 
	    );

	    GenreDomain genreDomain = GenreDomain.create(
	        UUIDHelper.convertToUUID(dtoToAdapt.getGenre().getId()),
	        dtoToAdapt.getGenre().getName() 
	    );

	    TypeGarmentDomain typeGarmentDomain = TypeGarmentDomain.create(
	    	    UUIDHelper.convertToUUID(dtoToAdapt.getTypeGarment().getId()),
	    	    dtoToAdapt.getTypeGarment().getName() 
	    	);

	    return GarmentConfigurationDomain.create(
	        UUIDHelper.convertToUUID(dtoToAdapt.getId()),
	        categoryDomain,
	        genreDomain,
	        typeGarmentDomain
	    );
	}
	
	@Override
	public GarmentConfigurationDTO adaptTarget(final GarmentConfigurationDomain data) {
	   
	    var domainToAdapt = ObjectHelper.getDefault(
	        data, GarmentConfigurationDomain.create(
	            UUIDHelper.getDefault(),
	            CategoryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY),
	            GenreDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY),
	            TypeGarmentDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY)
	        )
	    );

	   
	    CategoryDTO categoryDTO = CategoryDTO.create()
	        .setId(domainToAdapt.getCategory().getId().toString())
	        .setName(domainToAdapt.getCategory().getName());

	   
	    GenreDTO genreDTO = GenreDTO.create()
	        .setId(domainToAdapt.getGenre().getId().toString())
	        .setName(domainToAdapt.getGenre().getName());

	   
	    TypeGarmentDTO typeGarmentDTO = TypeGarmentDTO.create()
	        .setId(domainToAdapt.getTypeGarment().getId().toString())
	        .setName(domainToAdapt.getTypeGarment().getName());

	   
	    return GarmentConfigurationDTO.create()
	        .setCategory(categoryDTO)
	        .setGenre(genreDTO)
	        .setTypeGarment(typeGarmentDTO);
	}
}


