package mntone.univschedule.client;

/**
 * UniversityClassScheduleException.
 */
public final class UniversityScheduleException extends Exception
{
	private final UniversityScheduleExceptionReason mReason;
	private final Exception mInnerException;
	private final int mErrorCode;

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param reason the reason
	 */
	UniversityScheduleException( UniversityScheduleExceptionReason reason )
	{
		this.mReason = reason;
		this.mInnerException = null;
		this.mErrorCode = -1;
	}

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param reason the reason
	 * @param innerException the inner exception
	 */
	UniversityScheduleException( UniversityScheduleExceptionReason reason, Exception innerException )
	{
		this.mReason = reason;
		this.mInnerException = innerException;
		this.mErrorCode = -1;
	}

	/**
	 * Initialize a new university class schedule exception.
	 *
	 * @param errorCode the error code
	 */
	UniversityScheduleException( int errorCode )
	{
		this.mReason = UniversityScheduleExceptionReason.WEB_EXCEPTION;
		this.mInnerException = null;
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
	 * Get inner exception.
	 *
	 * @return the inner exception
	 */
	public Exception getInnerException()
	{
		return this.mInnerException;
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
