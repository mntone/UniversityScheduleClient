package mntone.univschedule.core;

import org.json.JSONObject;

import java.util.Date;

/**
 * PeriodInfo.
 */
public final class PeriodInfo
{
	private final Date mFrom;
	private final Date mTo;

	/**
	 * Initialize a new PeriodInfo.
	 *
	 * @param from the from
	 * @param to the to
	 */
	public PeriodInfo( final Date from, final Date to )
	{
		this.mFrom = from;
		this.mTo = to;
	}

	/**
	 * Initialize a new PeriodInfo.
	 *
	 * @param periodInfo the period info
	 */
	public PeriodInfo( final JSONObject periodInfo )
	{
		this.mFrom = JsonUtil.convertStringToTimeWithISO8601( periodInfo.getString( "from" ) );
		this.mTo = JsonUtil.convertStringToTimeWithISO8601( periodInfo.getString( "to" ) );
	}

	/**
	 * Get from.
	 *
	 * @return the from
	 */
	public Date getFrom()
	{
		return this.mFrom;
	}

	/**
	 * Get to.
	 *
	 * @return the to
	 */
	public Date getTo()
	{
		return this.mTo;
	}
}