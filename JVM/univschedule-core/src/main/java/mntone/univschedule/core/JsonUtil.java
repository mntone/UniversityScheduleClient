package mntone.univschedule.core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class JsonUtil
{
	interface InstanceFactory<T>
	{
		T createInstance( JSONObject json );

		T[] createArray( int size );
	}

	public static <T> T[] convertJsonArrayToArray( final JSONArray items, final InstanceFactory<T> factory )
	{
		if( items == null )
		{
			return null;
		}

		final ArrayList<T> retArrayList = new ArrayList<T>();
		for( int i = 0; i < items.length(); ++i )
		{
			final T item = factory.createInstance( items.getJSONObject( i ) );
			retArrayList.add( item );
		}
		return retArrayList.toArray( factory.createArray( retArrayList.size() ) );
	}

	private static final Date DATE_MIN = new Date( 0 );
	private static final SimpleDateFormat ISO8601_DATETIME_FORMAT;
	private static final SimpleDateFormat ISO8601_DATE_FORMAT;

	static
	{
		ISO8601_DATETIME_FORMAT = new SimpleDateFormat( "yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'", Locale.US );
		ISO8601_DATETIME_FORMAT.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
		ISO8601_DATE_FORMAT = new SimpleDateFormat( "yyyy'-'MM'-'dd", Locale.US );
		ISO8601_DATE_FORMAT.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
	}

	public static Date convertStringToDateTimeWithISO8601( final String dateTime )
	{
		try
		{
			return ISO8601_DATETIME_FORMAT.parse( dateTime );
		}
		catch( final ParseException ignored )
		{
		}
		return DATE_MIN;
	}

	public static Date convertStringToDateWithISO8601( final String date )
	{
		try
		{
			return ISO8601_DATE_FORMAT.parse( date );
		}
		catch( final ParseException ignored )
		{
		}
		return DATE_MIN;
	}
}