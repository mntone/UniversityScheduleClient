package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Date;

/**
 * Universities
 */
public final class Universities
{
	/**
	 * Factory
	 */
	public static class FriendUniversities
	{
		/**
		 * Instantiates a new Friend universities.
		 */
		protected FriendUniversities()
		{
			if( !this.getClass().getName().startsWith( "mntone.univschedule.client." ) )
			{
				throw new RuntimeException();
			}
		}

		/**
		 * Create universities.
		 *
		 * @param message the message
		 * @param universities the array of the university
		 * @param modifiedAt the last modified date time
		 * @return the universities
		 */
		public Universities createUniversities( String message, University[] universities, Date modifiedAt )
		{
			return new Universities( message, universities, modifiedAt );
		}

		/**
		 * Create universities.
		 *
		 * @param root the json of the root
		 * @return the universities
		 */
		public Universities createUniversities( JSONObject root )
		{
			return new Universities( root );
		}
	}

	private final String mMessage;
	private final University[] mUniversities;
	private final Date mModifiedAt;

	/**
	 * Initialize a new Universities.
	 *
	 * @param message the message
	 * @param universities the array of the university
	 * @param modifiedAt the last modified date time
	 */
	Universities( String message, University[] universities, Date modifiedAt )
	{
		this.mMessage = message;
		this.mUniversities = universities;
		this.mModifiedAt = modifiedAt;
	}

	/**
	 * Initialize a new Universities.
	 *
	 * @param root the json of the root
	 */
	Universities( JSONObject root )
	{
		this.mMessage = root.getString( "message" );
		this.mUniversities = JsonUtil.convertJsonArrayToArray(
			root.getJSONArray( "items" ), new JsonUtil.InstanceFactory<University>()
			{
				@Override
				public University createInstance( JSONObject json )
				{
					return new University( json );
				}

				@Override
				public University[] createArray( int size )
				{
					return new University[size];
				}
			} );
		this.mModifiedAt = JsonUtil.convertStringToDateWithISO8601( root.getString( "last_update" ) );
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
	 * Get universities.
	 *
	 * @return the array of university
	 */
	public University[] getUniversities()
	{
		return this.mUniversities;
	}

	/**
	 * Get modified at.
	 *
	 * @return the last modified
	 */
	public Date getModifiedAt()
	{
		return this.mModifiedAt;
	}
}