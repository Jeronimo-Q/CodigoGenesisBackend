package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizePerGarmentDomain;
import co.com.munamu.munamuinventory.domain.TypeGarmentDomain;
import co.com.munamu.munamuinventory.entity.SizePerGarmentEntity;
import co.com.munamu.munamuinventory.entity.TypeGarmentEntity;

public class TypeGarmentEntityAdapter implements Adapter<TypeGarmentDomain,TypeGarmentEntity> {
	private static final Adapter<TypeGarmentDomain,TypeGarmentEntity> instance = new TypeGarmentEntityAdapter();
	
	private TypeGarmentEntityAdapter() {
		
	}
	
	public static Adapter<TypeGarmentDomain,TypeGarmentEntity> getTypeGarmentEntityAdapter(){
		return instance;
	}
	
	@Override
	public TypeGarmentDomain adaptSource(final TypeGarmentEntity data) {
		return null;
	}
	
	@Override
	public TypeGarmentEntity adaptTarget(final TypeGarmentDomain data) {
		return null;
	}
}


