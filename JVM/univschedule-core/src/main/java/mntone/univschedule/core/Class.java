package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Date;

/**
 * Class
 */
public final class Class
{
	private final String mHash;
	private final Date mDate;
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
	 * @param hash       the hash
	 * @param date       the date
	 * @param period     the period
	 * @param campusName the campus
	 * @param department the department
	 * @param subject    the subject
	 * @param lecturer   the lecture
	 * @param grade      the grade
	 * @param note       the note
	 */
	Class(
		final String hash,
		final Date date,
		final Period period,
		final String campusName,
		final String department,
		final String subject,
		final String lecturer,
		final String grade,
		final String note )
	{
		this.mHash = hash;
		this.mDate = date;
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
	Class( final JSONObject klass )
	{
		this.mHash = klass.getString( "hash" );
		this.mDate = JsonUtil.convertStringToDateWithISO8601( klass.getString( "date" ) );
		this.mPeriod = new Period( klass.getJSONObject( "period" ) );
		this.mCampusName = klass.getString( "campus_name" );
		this.mDepartment = klass.getString( "department" );
		this.mSubject = klass.getString( "subject" );
		this.mLecturer = klass.getString( "lecturer" );
		this.mGrade = klass.getString( "grade" );
		this.mNote = klass.getString( "note" );
	}

	/**
	 * Get hash.
	 *
	 * @return the hash
	 */
	public String getHash()
	{
		return this.mHash;
	}

	/**
	 * Get date.
	 *
	 * @return the date
	 */
	public Date getDate()
	{
		return this.mDate;
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