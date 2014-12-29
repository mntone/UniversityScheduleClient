using System;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal static class HttpClientExtensions
	{
		public static Task<Tuple<HttpResponseHeaders, string>> GetHeadersAndStringAsync( this HttpClient client, string uri )
		{
			return client
				.SendAsync( new HttpRequestMessage( HttpMethod.Get, uri ) )
				.ContinueWith( prevTask =>
					{
						var result = prevTask.Result;
						if( result.StatusCode == HttpStatusCode.OK )
						{
							var header = result.Headers;
							return result.Content.ReadAsStringAsync().ContinueWith( prevTask2 => Tuple.Create( header, prevTask2.Result ) );
						}
						else if( result.StatusCode == HttpStatusCode.NotModified )
						{
							throw new UniversityScheduleException( UniversityScheduleExceptionReason.NOT_MODIFIED );
						}
						throw new UniversityScheduleException( ( int )result.StatusCode );
					} )
				.Unwrap();
		}
	}
}