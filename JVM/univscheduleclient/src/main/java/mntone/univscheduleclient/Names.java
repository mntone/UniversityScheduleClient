package mntone.univscheduleclient;

import org.json.JSONObject;

/**
 * Names
 */
public final class Names
{
	private final String mLocal;
	private final String mEnglishUnitedStates;

	/**
	 * Initialize a new Names.
	 *
	 * @param local the local
	 * @param englishUnitedStates the english united states
	 */
	Names( String local, String englishUnitedStates )
	{
		this.mLocal = local;
		this.mEnglishUnitedStates = englishUnitedStates;
	}

	/**
	 * Initialize a new Names.
	 *
	 * @param names the json of names
	 */
	Names( JSONObject names )
	{
		this.mLocal = names.getString( "local" );
		this.mEnglishUnitedStates = names.getString( "en_us" );
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
}