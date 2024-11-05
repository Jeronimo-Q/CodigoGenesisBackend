package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

public final class TypeGarmentEntityAdapter implements Adapter<TypeGarmentDomain,TypeGarmentEntity> {
	private static final Adapter<TypeGarmentDomain,TypeGarmentEntity> instance = new TypeGarmentEntityAdapter();
	
	private TypeGarmentEntityAdapter() {
		
	}
	
	public static Adapter<TypeGarmentDomain,TypeGarmentEntity> getTypeGarmentEntityAdapter(){
		return instance;
	}
	
	@Override
	public TypeGarmentDomain adaptTarjet(final TypeGarmentEntity data) {
		var entityToAdapt = ObjectHelper.getDefault(data,TypeGarmentEntity.create());
		return TypeGarmentDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public TypeGarmentEntity adaptSource(final TypeGarmentDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				TypeGarmentDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new TypeGarmentEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}

	@Override
	public List<TypeGarmentEntity> adaptSource(List<TypeGarmentDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeGarmentDomain> adaptTarjet(List<TypeGarmentEntity> data) {
		// TODO Auto-generated method stub
		return null;
	}
}


