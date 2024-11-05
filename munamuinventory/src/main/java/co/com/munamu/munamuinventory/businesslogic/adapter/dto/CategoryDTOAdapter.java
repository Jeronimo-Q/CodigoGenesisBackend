package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.dto.CategoryDTO;

public final class CategoryDTOAdapter implements Adapter<CategoryDomain,CategoryDTO>{
	private static final Adapter<CategoryDomain, CategoryDTO> instance = new CategoryDTOAdapter();
	
	private CategoryDTOAdapter() {
		
	}
	
	public static Adapter<CategoryDomain,CategoryDTO> getCategoryDTOAdapter(){
		return instance;
	}
	@Override
	public CategoryDomain adaptTarjet(final CategoryDTO data) {
		var dtoToAdapt=ObjectHelper.getDefault(data,CategoryDTO.create());
		return CategoryDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getName());
	}
	
	@Override
	public CategoryDTO adaptSource(final CategoryDomain data) {
		var domainToAdapt=ObjectHelper.getDefault(data,CategoryDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
		return CategoryDTO.create().setId(TextHelper.EMPTY).setName(domainToAdapt.getName());
	}

	@Override
	public List<CategoryDTO> adaptSource(List<CategoryDomain> data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDomain> adaptTarjet(List<CategoryDTO> data) {
		// TODO Auto-generated method stub
		return null;
	}
}
