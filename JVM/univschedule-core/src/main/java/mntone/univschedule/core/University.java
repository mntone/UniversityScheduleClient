package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Map;

/**
 * University
 */
public final class University
{
	private final int mId;
	private final String mScreenName;
	private final String mMessage;
	private final Names mNames;
	private final Campus[] mCampuses;
	private final Map<Integer, PeriodInfo> mTimetable;

	/**
	 * Initialize a new University.
	 *
	 * @param id         the id
	 * @param screenName the screen name
	 * @param message    the message
	 * @param names      the name
	 * @param campuses   the campuses
	 * @param timetable  the timetable
	 */
	University( final int id, final String screenName, final String message, final Names names, final Campus[] campuses, final Map<Integer, PeriodInfo> timetable )
	{
		this.mId = id;
		this.mScreenName = screenName;
		this.mMessage = message;
		this.mNames = names;
		this.mCampuses = campuses;
		this.mTimetable = timetable;
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
		this.mMessage = university.getString( "message" );
		this.mNames = new Names( university.getJSONObject( "names" ) );
		this.mCampuses = JsonUtil.convertJsonArrayToArray(
			university.optJSONArray( "campuses" ), new JsonUtil.ArrayInstanceFactory<Campus>()
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
		this.mTimetable = JsonUtil.convertJsonObjectToHashMap(
			university.getJSONObject( "timetable" ), new JsonUtil.BasicInstanceFactory<PeriodInfo>()
			{
				@Override
				public PeriodInfo createInstance( final JSONObject json )
				{
					return new PeriodInfo( json );
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
	 * Get message.
	 *
	 * @return the message
	 */
	public String getMessage()
	{
		return this.mMessage;
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

	/**
	 * Get timetable.
	 *
	 * @return the timetable
	 */
	public Map<Integer, PeriodInfo> getTimetable()
	{
		return this.mTimetable;
	}
}
