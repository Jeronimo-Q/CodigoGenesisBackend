package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.entity.CategoryEntity;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;
import co.com.munamu.munamuinventory.entity.GenreEntity;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

public final class GarmentConfigurationEntityAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> {
	private static final Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> instance = new GarmentConfigurationEntityAdapter();
	
	private GarmentConfigurationEntityAdapter() {
		
	}
	
	public static Adapter<GarmentConfigurationDomain,GarmentConfigurationEntity> getGarmentConfigurationEntityAdapter(){
		return instance;
	}
	
	@Override
	public GarmentConfigurationDomain adaptSource(final GarmentConfigurationEntity data) {
	    var entityToAdapt = ObjectHelper.getDefault(data, GarmentConfigurationEntity.create());

		   
	    CategoryDomain categoryDomain = CategoryEntityAdapter.getCategoryEntityAdapter().adaptSource(entityToAdapt.getCategory());

	    GenreDomain genreDomain = GenreEntityAdapter.getGenreEntityAdapter().adaptSource(entityToAdapt.getGenre());

	    TypeGarmentDomain typeGarmentDomain = TypeGarmentEntityAdapter.getTypeGarmentEntityAdapter().adaptSource(entityToAdapt.getTypeGarment());

	    return GarmentConfigurationDomain.create(
	        UUIDHelper.convertToUUID(entityToAdapt.getId()),
	        categoryDomain,
	        genreDomain,
	        typeGarmentDomain
	    );
	}
	
	@Override
	public GarmentConfigurationEntity adaptTarget(final GarmentConfigurationDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data, GarmentConfigurationDomain.create(UUIDHelper.getDefault(),
				CategoryDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
				GenreDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY), 
				TypeGarmentDomain.create(UUIDHelper.getDefault(), TextHelper.EMPTY)));
		
		CategoryEntity categoryEntity = CategoryEntityAdapter.getCategoryEntityAdapter().adaptTarget(domainToAdapt.getCategory());
		
		GenreEntity genreEntity = GenreEntityAdapter.getGenreEntityAdapter().adaptTarget(domainToAdapt.getGenre());
		
		TypeGarmentEntity typeGarmentEntity = TypeGarmentEntityAdapter.getTypeGarmentEntityAdapter().adaptTarget(domainToAdapt.getTypeGarment());
		
		var entityAdapted = new GarmentConfigurationEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setCategory(categoryEntity);
		entityAdapted.setGenre(genreEntity);
		entityAdapted.setTypeGarment(typeGarmentEntity);
		
		return entityAdapted;

	}
}


