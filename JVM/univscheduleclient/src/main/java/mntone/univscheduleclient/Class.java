package mntone.univscheduleclient;

import org.json.JSONObject;

/**
 * Class
 */
public final class Class
{
	private final String mId;
	private final Period mPeriod;
	private final String mCampusName;
	private final String mDepartment;
	private final String mSubject;
	private final String mLecturer;
	private final String mGrade;
	private final String mNote;

	/**
	 * Initialize a new class.
	 *
	 * @param id         the id
	 * @param period     the period
	 * @param campusName the campus
	 * @param department the department
	 * @param subject    the subject
	 * @param lecturer   the lecture
	 * @param grade      the grade
	 * @param note       the note
	 */
	Class( String id, Period period, String campusName, String department, String subject, String lecturer, String grade, String note )
	{
		this.mId = id;
		this.mPeriod = period;
		this.mCampusName = campusName;
		this.mDepartment = department;
		this.mSubject = subject;
		this.mLecturer = lecturer;
		this.mGrade = grade;
		this.mNote = note;
	}

	/**
	 * Initialize a new Class.
	 *
	 * @param klass the json of class
	 */
	Class( JSONObject klass )
	{
		this.mId = klass.getString( "hash" );
		this.mPeriod = new Period( klass.getJSONObject( "period" ) );
		this.mCampusName = klass.getString( "campus_name" );
		this.mDepartment = klass.getString( "department" );
		this.mSubject = klass.getString( "subject" );
		this.mLecturer = klass.getString( "lecturer" );
		this.mGrade = klass.getString( "grade" );
		this.mNote = klass.getString( "note" );
	}

	/**
	 * Get id.
	 *
	 * @return the id
	 */
	public String getId()
	{
		return this.mId;
	}

	/**
	 * Get id.
	 *
	 * @return the id
	 */
	public Period getPeriod()
	{
		return this.mPeriod;
	}

	/**
	 * Get campus name.
	 *
	 * @return the campusName
	 */
	public String getCampusName()
	{
		return this.mCampusName;
	}

	/**
	 * Get department.
	 *
	 * @return the department
	 */
	public String getDepartment()
	{
		return this.mDepartment;
	}

	/**
	 * Get subject.
	 *
	 * @return the subject
	 */
	public String getSubject()
	{
		return this.mSubject;
	}

	/**
	 * Get lecturer.
	 *
	 * @return the lecturer
	 */
	public String getLecturer()
	{
		return this.mLecturer;
	}

	/**
	 * Get grade.
	 *
	 * @return the grade
	 */
	public String getGrade()
	{
		return this.mGrade;
	}

	/**
	 * Get note.
	 *
	 * @return the note
	 */
	public String getNote()
	{
		return this.mNote;
	}
}