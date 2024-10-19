package co.com.munamu.dto;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class CategoryDTO extends DomainDTO{
	
	private String name;
	
	public CategoryDTO() {
		super(UUIDHelper.getDefaultAssString());
		setName(TextHelper.EMPTY);
	}
	
	public static final CategoryDTO create() {
		return new CategoryDTO();
	}

	public String getName() {
		return name;
	}

	public CategoryDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	

	public CategoryDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
	

	
}
