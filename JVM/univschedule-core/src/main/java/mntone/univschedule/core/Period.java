package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * Period
 */
public final class Period
{
	private final byte mFrom;
	private final byte mTo;

	/**
	 * Initialize a new period.
	 *
	 * @param from the from
	 * @param to   the to
	 */
	Period( byte from, byte to )
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
		this.mFrom = ( byte )period.getInt( "from" );
		this.mTo = ( byte )period.getInt( "to" );
	}

	/**
	 * Get from.
	 *
	 * @return the from
	 */
	public byte getFrom()
	{
		return this.mFrom;
	}

	/**
	 * Get to.
	 *
	 * @return the to
	 */
	public byte getTo()
	{
		return this.mTo;
	}
}