package mntone.univscheduleclient;

import org.json.JSONObject;

/**
 * Coordinates
 */
public final class Coordinates
{
	private final float mLongitude;
	private final float mLatitude;

	/**
	 * Initialize a new Coordinates.
	 *
	 * @param longitude the longitude
	 * @param latitude the latitude
	 */
	Coordinates( float longitude, float latitude )
	{
		this.mLongitude = longitude;
		this.mLatitude = latitude;
	}

	/**
	 * Initialize a new Coordinates.
	 *
	 * @param coordinates the coordinates
	 */
	Coordinates( JSONObject coordinates )
	{
		this.mLongitude = ( float )coordinates.getDouble( "longitude" );
		this.mLatitude = ( float )coordinates.getDouble( "latitude" );
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

	/**
	 * Get latitude.
	 *
	 * @return the latitude
	 */
	public float getLatitude()
	{
		return this.mLatitude;
	}
}