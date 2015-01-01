package mntone.univschedule.client;

/**
 * UniversityClassScheduleException.
 */
public final class UniversityScheduleException extends RuntimeException
{
	private final UniversityScheduleExceptionReason mReason;
	private final int mErrorCode;

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param reason the reason
	 */
	UniversityScheduleException( final UniversityScheduleExceptionReason reason )
	{
		this.mReason = reason;
		this.mErrorCode = -1;
	}

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param reason         the reason
	 * @param innerException the inner exception
	 */
	UniversityScheduleException( final UniversityScheduleExceptionReason reason, final Exception innerException )
	{
		super( innerException );
		this.mReason = reason;
		this.mErrorCode = -1;
	}

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param errorCode the error code
	 */
	UniversityScheduleException( final int errorCode )
	{
		this.mReason = UniversityScheduleExceptionReason.WEB_EXCEPTION;
		this.mErrorCode = errorCode;
	}

	/**
	 * Get reason.
	 *
	 * @return the reason
	 */
	public UniversityScheduleExceptionReason getReason()
	{
		return this.mReason;
	}

	/**
	 * Get error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode()
	{
		return this.mErrorCode;
	}
}
