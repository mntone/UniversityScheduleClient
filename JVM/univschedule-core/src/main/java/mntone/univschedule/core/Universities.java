package mntone.univschedule.core;

import org.json.JSONObject;

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
		 * @param message      the message
		 * @param universities the array of the university
		 * @return the universities
		 */
		public Universities createUniversities( String message, University[] universities )
		{
			return new Universities( message, universities );
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

	/**
	 * Initialize a new Universities.
	 *
	 * @param message      the message
	 * @param universities the array of the university
	 */
	Universities( String message, University[] universities )
	{
		this.mMessage = message;
		this.mUniversities = universities;
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
}