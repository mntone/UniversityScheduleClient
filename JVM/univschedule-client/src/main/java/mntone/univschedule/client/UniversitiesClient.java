package mntone.univschedule.client;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import mntone.univschedule.core.UniversitiesResponse;

class UniversitiesClient
{
	static UniversitiesResponse getUniversities( final UniversityScheduleClient context ) throws UniversityScheduleException
	{
		UniversitiesResponse ret = null;

		HttpURLConnection connection = null;
		try
		{
			final URL url = new URL( String.format( UniversityScheduleUrls.UNIVERSTIES_URL, context.getAccessKey() ) );
			connection = HttpUtil.getConnection( context, url );
			connection.connect();

			if( connection.getResponseCode() == HttpURLConnection.HTTP_OK )
			{
				{
					final String value = connection.getHeaderField( "last-modified" );
					if( value != null )
					{
						context.setUniverstiesModifiedAt( HttpUtil.convertStringToDateWithRFC1123( value ) );
					}
				}

				final String jsonText = HttpUtil.getString( connection );
				final JSONTokener reader = new JSONTokener( jsonText );
				final JSONObject root = new JSONObject( reader );
				ret = UniversityScheduleClient.UNIVERSITIES_BRIDGE.createUniversitiesResponse( root );
			}
		}
		catch( final IOException ex )
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