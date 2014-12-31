package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * Names
 */
public final class Names
{
	private final String mLocal;
	private final String mEnglishUnitedStates;
	private final String mRegion;

	/**
	 * Initialize a new Names.
	 *
	 * @param local               the local
	 * @param englishUnitedStates the english united states
	 * @param region              the region
	 */
	Names( final String local, final String englishUnitedStates, final String region )
	{
		this.mLocal = local;
		this.mEnglishUnitedStates = englishUnitedStates;
		this.mRegion = region;
	}

	/**
	 * Initialize a new Names.
	 *
	 * @param names the json of names
	 */
	Names( final JSONObject names )
	{
		this.mLocal = names.getString( "local" );
		this.mEnglishUnitedStates = names.getString( "en_us" );
		this.mRegion = names.getString( "locale" );
	}

	/**
	 * Get name in local language.
	 *
	 * @return the name
	 */
	public String getLocal()
	{
		return this.mLocal;
	}

	/**
	 * Get name in English (US).
	 *
	 * @return the name
	 */
	public String getEnglishUnitedStates()
	{
		return this.mEnglishUnitedStates;
	}

	/**
	 * Gets region.
	 *
	 * @return the region
	 */
	public String getRegion()
	{
		return this.mRegion;
	}
}