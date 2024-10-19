package co.com.munamu.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GeneroEntity extends DomainEntity{
	
	private String name;
	
	public GeneroEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	
	public static final GeneroEntity create() {
		return new GeneroEntity();
	}

	public String getName() {
		return name;
	}

	public GeneroEntity setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
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
