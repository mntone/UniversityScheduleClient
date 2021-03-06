package mntone.univschedule.client;

import java.util.Date;

import mntone.univschedule.core.Class;
import mntone.univschedule.core.ClassResponse;
import mntone.univschedule.core.ClassesResponse;
import mntone.univschedule.core.UniversitiesResponse;
import mntone.univschedule.core.University;

/**
 * Client for university class schedule
 */
public final class UniversityScheduleClient
{
	static final class UniversitiesBridge extends UniversitiesResponse.FriendUniversities
	{
	}

	static final class ClassesBridge extends ClassesResponse.FriendClasses
	{
	}

	static final class ClassBridge extends ClassResponse.FriendClass
	{
	}

	static final UniversitiesBridge UNIVERSITIES_BRIDGE = new UniversitiesBridge();
	static final ClassesBridge CLASSES_BRIDGE = new ClassesBridge();
	static final ClassBridge CLASS_BRIDGE = new ClassBridge();

	static final String X_UNIVS_LAST_MODIFIED = "X-UCS-UNIVS-LAST-MODIFIED";
	static final String DEFAULT_USER_AGENT = "UniversityScheduleClient for Java/0.9";

	private final String mAccessKey;
	private String mAdditionalUserAgent = null;
	private Date mUniverstiesModifiedAt = new Date( 0 );

	/**
	 * Initialize a new client for university class schedule.
	 *
	 * @param accessKey the access key
	 */
	public UniversityScheduleClient( final String accessKey )
	{
		this.mAccessKey = accessKey;
	}

	/**
	 * Get universities.
	 *
	 * @return the array of University
	 * @throws UniversityScheduleException the UniversityClassScheduleException
	 */
	public UniversitiesResponse getUniversities() throws UniversityScheduleException
	{
		return UniversitiesClient.getUniversities( this );
	}

	/**
	 * Get classes.
	 *
	 * @param university the university
	 * @return the classes
	 * @throws UniversityScheduleException the UniversityClassScheduleException
	 */
	public ClassesResponse getClasses( final University university ) throws UniversityScheduleException
	{
		return this.getClasses( university.getScreenName() );
	}

	/**
	 * Get classes.
	 *
	 * @param universityScreenName the screen name of university
	 * @return the classes
	 * @throws UniversityScheduleException the UniversityClassScheduleException
	 */
	public ClassesResponse getClasses( final String universityScreenName ) throws UniversityScheduleException
	{
		return ClassesClient.getClasses( this, universityScreenName );
	}

	/**
	 * Get class.
	 *
	 * @param klass the university
	 * @return the class
	 * @throws UniversityScheduleException the UniversityClassScheduleException
	 */
	public ClassResponse getClass( final Class klass ) throws UniversityScheduleException
	{
		return this.getClass( klass.getHash() );
	}

	/**
	 * Get class.
	 *
	 * @param classHash the screen name of university
	 * @return the class
	 * @throws UniversityScheduleException the UniversityClassScheduleException
	 */
	public ClassResponse getClass( final String classHash ) throws UniversityScheduleException
	{
		return ClassClient.getClass( this, classHash );
	}

	/**
	 * Get access key.
	 *
	 * @return the access key
	 */
	public String getAccessKey()
	{
		return this.mAccessKey;
	}

	/**
	 * Get additional user agent.
	 *
	 * @return the additional user agent
	 */
	public String getAdditionalUserAgent()
	{
		return this.mAdditionalUserAgent;
	}

	/**
	 * Set additional user agent.
	 *
	 * @param additionalUserAgent the additional user agent
	 */
	public void setAdditionalUserAgent( final String additionalUserAgent )
	{
		this.mAdditionalUserAgent = additionalUserAgent;
	}

	/**
	 * Get last modified of university list.
	 *
	 * @return the last modified of university list
	 */
	public Date getUniverstiesModifiedAt()
	{
		return this.mUniverstiesModifiedAt;
	}

	/**
	 * Set last modified of university list..
	 *
	 * @param value the last modified of university list.
	 */
	public void setUniverstiesModifiedAt( final Date value )
	{
		this.mUniverstiesModifiedAt = value;
	}
}