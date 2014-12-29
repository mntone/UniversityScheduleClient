package mntone.univschedule.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

class HttpUtil
{
	public static HttpURLConnection getConnection( UniversityScheduleClient context, URL url ) throws IOException
	{
		final HttpURLConnection connection = ( HttpURLConnection )url.openConnection();
		connection.setRequestMethod( "GET" );
		connection.setInstanceFollowRedirects( false );
		final String additionalUserAgent = context.getAdditionalUserAgent();
		connection.setRequestProperty(
			"User-Agent",
			additionalUserAgent != null
				? UniversityScheduleClient.DEFAULT_USER_AGENT + " (" + additionalUserAgent + ")"
				: UniversityScheduleClient.DEFAULT_USER_AGENT );
		connection.setRequestProperty( "Accept-Encoding", "gzip, deflate" );
		return connection;
	}

	public static String getString( HttpURLConnection connection ) throws UniversityScheduleException
	{
		String ret = null;
		try
		{
			final boolean isGzipped = connection.getHeaderField( "Content-Encoding" ).equals( "gzip" );
			final StringBuffer buffer = new StringBuffer();

			GZIPInputStream gzipStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader reader = null;
			try
			{
				if( isGzipped )
				{
					gzipStream = new GZIPInputStream( connection.getInputStream() );
					inputStreamReader = new InputStreamReader( gzipStream );
				}
				else
				{
					inputStreamReader = new InputStreamReader( connection.getInputStream() );
				}
				reader = new BufferedReader( inputStreamReader );
				String line = null;
				do
				{
					line = reader.readLine();
					buffer.append( line + "\n" );
				} while( line != null );
			}
			finally
			{
				if( reader != null )
				{
					reader.close();
				}
				if( inputStreamReader != null )
				{
					inputStreamReader.close();
				}
				if( gzipStream != null )
				{
					gzipStream.close();
				}
			}

			ret = buffer.toString();
		}
		catch( IOException ex )
		{
			throw new UniversityScheduleException( UniversityScheduleExceptionReason.PARSE_FAILED, ex );
		}
		return ret;
	}
}
