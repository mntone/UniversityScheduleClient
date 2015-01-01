package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Date;

/**
 * Classes
 */
public final class ClassesResponse
{
	/**
	 * Factory
	 */
	public static class FriendClasses
	{
		protected FriendClasses()
		{
			if( !this.getClass().getName().startsWith( "mntone.univschedule.client." ) )
			{
				throw new RuntimeException();
			}
		}

		/**
		 * Create classes.
		 *
		 * @param message    the message
		 * @param university the university
		 * @param classes    the array of the class
		 * @param modifiedAt the last modified date time
		 * @return the classes
		 */
		public ClassesResponse createClassesResponse( String message, University university, Class[] classes, Date modifiedAt )
		{
			return new ClassesResponse( message, university, classes, modifiedAt );
		}

		/**
		 * Create classes.
		 *
		 * @param root the json of the root
		 * @return the classes
		 */
		public ClassesResponse createClassesResponse( JSONObject root )
		{
			return new ClassesResponse( root );
		}
	}

	private final String mMessage;
	private final University mUniversity;
	private final Class[] mClasses;
	private final Date mModifiedAt;

	/**
	 * Initialize a new Classes.
	 *
	 * @param message    the message
	 * @param university the university
	 * @param classes    the array of the class
	 * @param modifiedAt the last modified date time
	 */
	ClassesResponse( final String message, final University university, final Class[] classes, final Date modifiedAt )
	{
		this.mMessage = message;
		this.mUniversity = university;
		this.mClasses = classes;
		this.mModifiedAt = modifiedAt;
	}

	/**
	 * Initialize a new Classes.
	 *
	 * @param root the json of the root
	 */
	ClassesResponse( final JSONObject root )
	{
		this.mMessage = root.getString( "message" );
		this.mUniversity = new University( root.getJSONObject( "university" ) );
		this.mClasses = JsonUtil.convertJsonArrayToArray(
			root.getJSONArray( "items" ), new JsonUtil.InstanceFactory<Class>()
			{
				@Override
				public Class createInstance( final JSONObject json )
				{
					return new Class( json );
				}

				@Override
				public Class[] createArray( final int size )
				{
					return new Class[size];
				}
			} );
		this.mModifiedAt = JsonUtil.convertStringToDateTimeWithISO8601( root.getString( "last_update" ) );
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
	 * Get university.
	 *
	 * @return the university
	 */
	public University getUniversity()
	{
		return this.mUniversity;
	}

	/**
	 * Get classes.
	 *
	 * @return the array of class
	 */
	public Class[] getClasses()
	{
		return this.mClasses;
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