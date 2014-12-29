package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * Period
 */
public final class Period
{
	private final int mFrom;
	private final int mTo;

	/**
	 * Initialize a new period.
	 *
	 * @param from the from
	 * @param to   the to
	 */
	Period( int from, int to )
	{
		this.mFrom = from;
		this.mTo = to;
	}

	/**
	 * Initialize a new Period.
	 *
	 * @param period the period
	 */
	Period( JSONObject period )
	{
		this.mFrom = period.getInt( "from" );
		this.mTo = period.getInt( "to" );
	}

	/**
	 * Get from.
	 *
	 * @return the from
	 */
	public int getFrom()
	{
		return this.mFrom;
	}

	/**
	 * Get to.
	 *
	 * @return the to
	 */
	public int getTo()
	{
		return this.mTo;
	}
}