package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * Names
 */
public final class Names
{
	private final String mLocal;
	private final String mEnglish;
	private final String mLanguage;

	/**
	 * Initialize a new Names.
	 *
	 * @param local    the local
	 * @param english  the english
	 * @param language the language
	 */
	Names( final String local, final String english, final String language )
	{
		this.mLocal = local;
		this.mEnglish = english;
		this.mLanguage = language;
	}

	/**
	 * Initialize a new Names.
	 *
	 * @param names the json of names
	 */
	Names( final JSONObject names )
	{
		this.mLocal = names.getString( "local" );
		this.mEnglish = names.getString( "english" );
		this.mLanguage = names.getString( "language" );
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
	 * Get name in English.
	 *
	 * @return the name
	 */
	public String getEnglish()
	{
		return this.mEnglish;
	}

	/**
	 * Gets local language (ISO 639-1).
	 *
	 * @return the local language
	 */
	public String getLanguage()
	{
		return this.mLanguage;
	}
}