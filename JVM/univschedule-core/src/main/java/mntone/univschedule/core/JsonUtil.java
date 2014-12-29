package mntone.univschedule.core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

class JsonUtil
{
	interface InstanceFactory<T>
	{
		T createInstance( JSONObject json );

		T[] createArray( int size );
	}

	public static <T> T[] convertJsonArrayToArray( JSONArray items, InstanceFactory<T> factory )
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
}