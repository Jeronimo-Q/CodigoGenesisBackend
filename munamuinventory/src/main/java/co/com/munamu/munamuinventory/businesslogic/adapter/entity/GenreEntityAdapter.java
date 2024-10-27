package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.entity.GenreEntity;

public class GenreEntityAdapter implements Adapter<GenreDomain,GenreEntity> {
	private static final Adapter<GenreDomain,GenreEntity> instance = new GenreEntityAdapter();
	
	private GenreEntityAdapter() {
		
	}
	
	public static Adapter<GenreDomain,GenreEntity> getGenreEntityAdapter(){
		return instance;
	}
	
	@Override
	public GenreDomain adaptSource(final GenreEntity data) {
		var entityToAdapt=ObjectHelper.getDefault(data,GenreEntity.create());
		return GenreDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public GenreEntity adaptTarget(final GenreDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				GenreDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new GenreEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}
}


