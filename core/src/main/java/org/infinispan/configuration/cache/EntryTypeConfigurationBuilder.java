package org.infinispan.configuration.cache;

import org.infinispan.commons.configuration.Builder;
import org.infinispan.configuration.global.GlobalConfiguration;

public class EntryTypeConfigurationBuilder extends AbstractConfigurationChildBuilder implements	Builder<EntryTypeConfiguration> {

	private Class<?> keyClass = Object.class;
	private Class<?> valueClass = Object.class;

	public EntryTypeConfigurationBuilder(ConfigurationBuilder builder) {
		super(builder);
	}

	@Override
	public void validate(GlobalConfiguration globalConfig) {
	}

	@Override
	public void validate() {
	}
	
	public EntryTypeConfigurationBuilder keyClass(Class<?> keyClass) {
		this.keyClass = keyClass;
		return this;
	}
	
	public EntryTypeConfigurationBuilder valueClass(Class<?> valueClass) {
		this.valueClass = valueClass;
		return this;
	}

	@Override
	public EntryTypeConfiguration create() {
		return new EntryTypeConfiguration(keyClass, valueClass);
	}

	@Override
	public Builder<?> read(EntryTypeConfiguration template) {
		this.keyClass = template.getKeyClass();
		this.valueClass = template.getValueClass();
		
		return this;
	}
}
