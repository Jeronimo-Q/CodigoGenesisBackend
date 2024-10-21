package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GenreDomain extends DomainEntity{
	
	private String name;
	
	public GenreDomain() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	public static final GenreDomain create() {
		return new GenreDomain();
	}

	public String getName() {
		return name;
	}

	public GenreDomain setName(final String name) {
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
