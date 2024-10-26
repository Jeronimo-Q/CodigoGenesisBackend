package co.com.munamu.munamuinventory.businesslogic.adapter.entity;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.entity.CategoryEntity;

public class CategoryEntityAdapter implements Adapter<CategoryDomain,CategoryEntity> {

	@Override
	public CategoryDomain adaptSource(final CategoryEntity data) {
		var entityToAdapt=ObjectHelper.getDefault(data,CategoryEntity.create());
		return CategoryDomain.create(entityToAdapt.getId(),entityToAdapt.getName());
	}
	
	@Override
	public CategoryEntity adaptTarget(final CategoryDomain data) {
		var domainToAdapt = ObjectHelper.getDefault(data,
				CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		
		var entityAdapted = new CategoryEntity();
		entityAdapted.setId(domainToAdapt.getId());
		entityAdapted.setName(domainToAdapt.getName());
		
		return entityAdapted;
	}
}


