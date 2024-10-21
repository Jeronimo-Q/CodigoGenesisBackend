package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GenreEntity extends DomainEntity{
	
	private String name;
	
	public GenreEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public void setId(final UUID id) {
		super.setId(id);
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
