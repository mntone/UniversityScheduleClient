package mntone.univschedule.client;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import mntone.univschedule.core.Classes;

class ClassesClient
{
	static Classes getClasses( UniversityScheduleClient context, String screenName ) throws UniversityScheduleException
	{
		Classes classes = null;

		HttpURLConnection connection = null;
		try
		{
			final URL url = new URL( String.format( UniversityScheduleUrls.CANCELLATIONS_URL, context.getAccessKey(), screenName ) );
			connection = HttpUtil.getConnection( context, url );
			connection.connect();

			final int statusCode = connection.getResponseCode();
			if( statusCode == HttpURLConnection.HTTP_OK )
			{
				final String jsonText = HttpUtil.getString( connection );
				final JSONTokener reader = new JSONTokener( jsonText );
				final JSONObject root = new JSONObject( reader );
				classes = UniversityScheduleClient.CLASSES_BRIDGE.createClasses( root );
			}
			else if( statusCode == HttpURLConnection.HTTP_NOT_MODIFIED )
			{
				throw new UniversityScheduleException( UniversityScheduleExceptionReason.NOT_MODIFIED );
			}
			else
			{
				throw new UniversityScheduleException( statusCode );
			}
		}
		catch( IOException ex )
		{
			throw new UniversityScheduleException( UniversityScheduleExceptionReason.UNKNOWN, ex );
		}
		finally
		{
			if( connection != null )
			{
				connection.disconnect();
			}
		}
		return classes;
	}
}
