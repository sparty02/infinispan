package org.infinispan.configuration.cache;

/**
 * Configures strong typing for a cache's entry and value classes.
 */
public class EntryTypeConfiguration {

	private final Class<?> keyClass;
	private final Class<?> valueClass;

	public EntryTypeConfiguration(Class<?> keyClass, Class<?> valueClass) {
		this.keyClass = keyClass;
		this.valueClass = valueClass;
	}

	/**
	 * The class of a cache entries key;
	 */
	public Class<?> getKeyClass() {
		return keyClass;
	}

	/**
	 * The class of a cache entries value;
	 */
	public Class<?> getValueClass() {
		return valueClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((keyClass == null) ? 0 : keyClass.hashCode());
		result = prime * result
				+ ((valueClass == null) ? 0 : valueClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntryTypeConfiguration other = (EntryTypeConfiguration) obj;
		if (keyClass == null) {
			if (other.keyClass != null)
				return false;
		} else if (!keyClass.equals(other.keyClass))
			return false;
		if (valueClass == null) {
			if (other.valueClass != null)
				return false;
		} else if (!valueClass.equals(other.valueClass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntryTypeConfiguration [keyClass=" + keyClass + ", valueClass="
				+ valueClass + "]";
	}

}
