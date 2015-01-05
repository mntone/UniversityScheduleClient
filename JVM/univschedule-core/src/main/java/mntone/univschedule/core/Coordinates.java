package mntone.univschedule.core;

import org.json.JSONObject;

/**
 * Coordinates
 */
public final class Coordinates
{
	private final float mLatitude;
	private final float mLongitude;

	/**
	 * Initialize a new Coordinates.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 */
	Coordinates( final float latitude, final float longitude )
	{
		this.mLatitude = latitude;
		this.mLongitude = longitude;
	}

	/**
	 * Initialize a new Coordinates.
	 *
	 * @param coordinates the coordinates
	 */
	Coordinates( final JSONObject coordinates )
	{
		this.mLatitude = ( float )coordinates.getDouble( "latitude" );
		this.mLongitude = ( float )coordinates.getDouble( "longitude" );
	}

	/**
	 * Get latitude.
	 *
	 * @return the latitude
	 */
	public float getLatitude()
	{
		return this.mLatitude;
	}

	/**
	 * Get longitude.
	 *
	 * @return the longitude
	 */
	public float getLongitude()
	{
		return this.mLongitude;
	}
}