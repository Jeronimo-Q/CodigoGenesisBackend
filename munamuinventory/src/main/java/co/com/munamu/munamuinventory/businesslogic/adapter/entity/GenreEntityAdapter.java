package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GenreDomain;
import co.com.munamu.munamuinventory.entity.GenreEntity;

public class GenreEntityAdapter implements Adapter<GenreDomain,GenreEntity> {

	@Override
	public GenreDomain adaptSource(final GenreEntity data) {
		return null;
	}
	
	@Override
	public GenreEntity adaptTarget(final GenreDomain data) {
		return null;
	}
}


