package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * University
 */
public final class University
{
	private final int mId;
	private final String mScreenName;
	private final Names mNames;
	private final Campus[] mCampuses;

	/**
	 * Initialize a new University.
	 *
	 * @param id         the id
	 * @param screenName the screen name
	 * @param names      the name
	 * @param campuses   the campuses
	 */
	University( final int id, final String screenName, final Names names, final Campus[] campuses )
	{
		this.mId = id;
		this.mScreenName = screenName;
		this.mNames = names;
		this.mCampuses = campuses;
	}

	/**
	 * Initialize a new University.
	 *
	 * @param university the json of university
	 */
	University( final JSONObject university )
	{
		this.mId = university.getInt( "id" );
		this.mScreenName = university.getString( "screen_name" );
		this.mNames = new Names( university.getJSONObject( "names" ) );
		this.mCampuses = JsonUtil.convertJsonArrayToArray(
			university.optJSONArray( "campuses" ), new JsonUtil.InstanceFactory<Campus>()
			{
				@Override
				public Campus createInstance( final JSONObject json )
				{
					return new Campus( json );
				}

				@Override
				public Campus[] createArray( final int size )
				{
					return new Campus[size];
				}
			} );
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
	 * Get campuses.
	 *
	 * @return the array of campus
	 */
	public Campus[] getCampuses()
	{
		return this.mCampuses;
	}
}
