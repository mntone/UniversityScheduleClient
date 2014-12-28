package mntone.univscheduleclient;

import org.json.JSONObject;

/**
 * Campus
 */
public final class Campus
{
	private final int mId;
	private final String mScreenName;
	private final Names mNames;
	private final Coordinates mCoordinates;

	/**
	 * Initialize a new University.
	 *
	 * @param id the id
	 * @param screenName the screen name
	 * @param names the name
	 * @param coordinates the coordinates
	 */
	Campus( int id, String screenName, Names names, Coordinates coordinates )
	{
		this.mId = id;
		this.mScreenName = screenName;
		this.mNames = names;
		this.mCoordinates = coordinates;
	}

	/**
	 * Initialize a new Campus.
	 *
	 * @param campus the json of campus
	 */
	Campus( JSONObject campus )
	{
		this.mId = campus.getInt( "id" );
		this.mScreenName = campus.getString( "screen_name" );
		this.mNames = new Names( campus.getJSONObject( "names" ) );
		this.mCoordinates = new Coordinates( campus.getJSONObject( "coordinates" ) );
	}

	/**
	 * Get id.
	 *
	 * @return the id
	 */
	public int getId()
	{
		return this.mId;
	}

	/**
	 * Get screen name.
	 *
	 * @return the screen name
	 */
	public String getScreenName()
	{
		return this.mScreenName;
	}

	/**
	 * Get names.
	 *
	 * @return the names
	 */
	public Names getNames()
	{
		return this.mNames;
	}

	/**
	 * Get coordinates.
	 *
	 * @return the coordinates
	 */
	public Coordinates getCoordinates()
	{
		return this.mCoordinates;
	}
}