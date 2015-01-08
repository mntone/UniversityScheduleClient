package mntone.univschedule.core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

class JsonUtil
{
	interface BasicInstanceFactory<T>
	{
		T createInstance( JSONObject json );
	}

	interface ArrayInstanceFactory<T> extends BasicInstanceFactory<T>
	{
		T[] createArray( int size );
	}

	public static <T> T[] convertJsonArrayToArray( final JSONArray items, final ArrayInstanceFactory<T> factory )
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

	interface MapKeyInstanceFactory<TKey, TValue> extends BasicInstanceFactory<TValue>
	{
		TKey createKeyInstance( String key );
	}

	public static <TValue> HashMap<Integer, TValue> convertJsonObjectToHashMap( final JSONObject obj, final BasicInstanceFactory<TValue> factory )
	{
		return convertJsonObjectToHashMap(
			obj, new MapKeyInstanceFactory<Integer, TValue>()
			{
				@Override
				public Integer createKeyInstance( final String key )
				{
					return Integer.parseInt( key );
				}

				@Override
				public TValue createInstance( final JSONObject json )
				{
					return factory.createInstance( json );
				}
			} );
	}

	public static <TKey, TValue> HashMap<TKey, TValue> convertJsonObjectToHashMap( final JSONObject obj, final MapKeyInstanceFactory<TKey, TValue> factory )
	{
		if( obj == null )
		{
			return null;
		}

		final HashMap<TKey, TValue> retHashMap = new HashMap<TKey, TValue>();
		final Iterator<String> itr = obj.keys();
		while( itr.hasNext() )
		{
			final String key = itr.next();
			final TKey newKey = factory.createKeyInstance( key );
			final TValue newValue = factory.createInstance( obj.getJSONObject( key ) );
			retHashMap.put( newKey, newValue );
		}
		return retHashMap;
	}

	private static final Date DATE_MIN = new Date( 0 );
	private static final SimpleDateFormat ISO8601_DATETIME_FORMAT;
	private static final SimpleDateFormat ISO8601_DATE_FORMAT;
	private static final SimpleDateFormat ISO8601_TIME_FORMAT;

	static
	{
		ISO8601_DATETIME_FORMAT = new SimpleDateFormat( "yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'", Locale.US );
		ISO8601_DATETIME_FORMAT.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
		ISO8601_DATE_FORMAT = new SimpleDateFormat( "yyyy'-'MM'-'dd", Locale.US );
		ISO8601_DATE_FORMAT.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
		ISO8601_TIME_FORMAT = new SimpleDateFormat( "HH':'mmZ", Locale.US );
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

	public static Date convertStringToTimeWithISO8601( final String date )
	{
		try
		{
			return ISO8601_TIME_FORMAT.parse( date + "00" );
		}
		catch( final ParseException ignored )
		{
		}
		return DATE_MIN;
	}
}