package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GenreDTO extends DomainDTO{
	
	private String name;
	
	public GenreDTO() {
		super(UUIDHelper.getDefaultAssString());
		setName(TextHelper.EMPTY);
	}
	
	public static final GenreDTO create() {
		return new GenreDTO();
	}

	public String getName() {
		return name;
	}

	public GenreDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	

	public GenreDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
	

	
}
