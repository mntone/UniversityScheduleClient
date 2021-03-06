package mntone.univschedule.client;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import mntone.univschedule.core.ClassResponse;

class ClassClient
{
	static ClassResponse getClass( final UniversityScheduleClient context, final String hash ) throws UniversityScheduleException
	{
		ClassResponse classes = null;

		HttpURLConnection connection = null;
		try
		{
			final URL url = new URL( String.format( UniversityScheduleUrls.CANCELLATIONS_SHOW_URL, context.getAccessKey(), hash ) );
			connection = HttpUtil.getConnection( context, url );
			connection.connect();

			final int statusCode = connection.getResponseCode();
			if( statusCode == HttpURLConnection.HTTP_OK )
			{
				HttpUtil.setUniversitiesModifiedAt( context, connection );

				final String jsonText = HttpUtil.getString( connection );
				final JSONTokener reader = new JSONTokener( jsonText );
				final JSONObject root = new JSONObject( reader );
				classes = UniversityScheduleClient.CLASS_BRIDGE.createClassResponse( root );
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
