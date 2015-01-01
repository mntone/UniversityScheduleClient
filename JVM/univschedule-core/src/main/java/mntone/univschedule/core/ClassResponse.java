package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Date;

/**
 * Classes
 */
public final class ClassResponse
{
	/**
	 * Factory
	 */
	public static class FriendClass
	{
		protected FriendClass()
		{
			if( !this.getClass().getName().startsWith( "mntone.univschedule.client." ) )
			{
				throw new RuntimeException();
			}
		}

		/**
		 * Create class.
		 *
		 * @param message    the message
		 * @param university the university
		 * @param klass      the class
		 * @param modifiedAt the last modified date time
		 * @return the class
		 */
		public ClassResponse createClassResponse( String message, University university, Class klass, Date modifiedAt )
		{
			return new ClassResponse( message, university, klass, modifiedAt );
		}

		/**
		 * Create class.
		 *
		 * @param root the json of the root
		 * @return the class
		 */
		public ClassResponse createClassResponse( JSONObject root )
		{
			return new ClassResponse( root );
		}
	}

	private final String mMessage;
	private final University mUniversity;
	private final Class mClass;
	private final Date mModifiedAt;

	/**
	 * Initialize a new Class.
	 *
	 * @param message    the message
	 * @param university the university
	 * @param klass      the class
	 * @param modifiedAt the last modified date time
	 */
	ClassResponse( final String message, final University university, final Class klass, final Date modifiedAt )
	{
		this.mMessage = message;
		this.mUniversity = university;
		this.mClass = klass;
		this.mModifiedAt = modifiedAt;
	}

	/**
	 * Initialize a new Class.
	 *
	 * @param root the json of the root
	 */
	ClassResponse( final JSONObject root )
	{
		this.mMessage = root.getString( "message" );
		this.mUniversity = new University( root.getJSONObject( "university" ) );
		this.mClass = new Class( root.getJSONObject( "item" ) );
		this.mModifiedAt = JsonUtil.convertStringToDateTimeWithISO8601( root.getString( "modified_at" ) );
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
	 * Get class.
	 *
	 * @return the class
	 */
	public Class getKlass()
	{
		return this.mClass;
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