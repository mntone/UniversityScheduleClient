package mntone.univscheduleclient;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class UniversitiesClient
{
	static Universities getUniversities( UniversityScheduleClient context ) throws UniversityScheduleException
	{
		Universities ret = null;

		HttpURLConnection connection = null;
		try
		{
			final URL url = new URL( String.format( UniversityScheduleUrls.UNIVERSTIES_URL, context.getAccessKey() ) );
			connection = HttpUtil.getConnection( context, url );
			connection.connect();

			if( connection.getResponseCode() == HttpURLConnection.HTTP_OK )
			{
				final String jsonText = HttpUtil.getString( connection );
				final JSONTokener reader = new JSONTokener( jsonText );
				final JSONObject root = new JSONObject( reader );
				ret = new Universities( root );
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
		return ret;
	}
}