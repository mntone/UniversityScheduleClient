package mntone.univschedule.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

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

	private static String getString( InputStreamReader inputStreamReader ) throws IOException
	{
		final StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		try
		{
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
		}
		return buffer.toString();
	}

	public static String getString( HttpURLConnection connection ) throws UniversityScheduleException
	{
		String ret = null;
		try
		{
			final String acceptEncoding = connection.getHeaderField( "Content-Encoding" );
			final boolean isGzipped = "gzip".equals( acceptEncoding );
			final boolean isDeflate = "deflate".equals( acceptEncoding );

			if( isGzipped )
			{
				GZIPInputStream gzipStream = null;
				InputStreamReader inputStreamReader = null;
				try
				{
					gzipStream = new GZIPInputStream( connection.getInputStream() );
					inputStreamReader = new InputStreamReader( gzipStream );
					ret = getString( inputStreamReader );
				}
				finally
				{
					if( inputStreamReader != null )
					{
						inputStreamReader.close();
					}
					if( gzipStream != null )
					{
						gzipStream.close();
					}
				}

			}
			else if( isDeflate )
			{
				InflaterInputStream inflaterStream = null;
				InputStreamReader inputStreamReader = null;
				try
				{
					inflaterStream = new InflaterInputStream( connection.getInputStream(), new Inflater( true ) );
					inputStreamReader = new InputStreamReader( inflaterStream );
					ret = getString( inputStreamReader );
				}
				finally
				{
					if( inputStreamReader != null )
					{
						inputStreamReader.close();
					}
					if( inflaterStream != null )
					{
						inflaterStream.close();
					}
				}
			}
			else
			{
				InputStreamReader inputStreamReader = null;
				try
				{
					inputStreamReader = new InputStreamReader( connection.getInputStream() );
					ret = getString( inputStreamReader );
				}
				finally
				{
					if( inputStreamReader != null )
					{
						inputStreamReader.close();
					}
				}
			}
		}
		catch( IOException ex )
		{
			throw new UniversityScheduleException( UniversityScheduleExceptionReason.PARSE_FAILED, ex );
		}
		return ret;
	}
}