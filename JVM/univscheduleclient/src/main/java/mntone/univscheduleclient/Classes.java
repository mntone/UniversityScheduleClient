package mntone.univscheduleclient;

import org.json.JSONObject;

/**
 * Classes
 */
public final class Classes
{
	private final String mMessage;
	private final University mUniversity;
	private final Class[] mClasses;

	/**
	 * Initialize a new Classes.
	 *
	 * @param message    the message
	 * @param university the university
	 * @param classes    the array of the class
	 */
	Classes( String message, University university, Class[] classes )
	{
		this.mMessage = message;
		this.mUniversity = university;
		this.mClasses = classes;
	}

	/**
	 * Initialize a new Classes.
	 *
	 * @param root the json of the root
	 */
	Classes( JSONObject root )
	{
		this.mMessage = root.getString( "message" );
		this.mUniversity = new University( root.getJSONObject( "university" ) );
		this.mClasses = JsonUtil.convertJsonArrayToArray(
			root.getJSONArray( "items" ), new JsonUtil.InstanceFactory<Class>()
			{
				@Override
				public Class createInstance( JSONObject json )
				{
					return new Class( json );
				}

				@Override
				public Class[] createArray( int size )
				{
					return new Class[size];
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
}