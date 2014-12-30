using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal static class UniversityScheduleHeaderProcessingExtensions
	{
		public static Task<string> GetStringWithHeaderProcessingAsync( this UniversityScheduleClient context, string uri )
		{
			return context.GetClient().GetStringWithHeaderProcessingAsync( uri, context );
		}

		public static Task<string> GetStringWithHeaderProcessingAsync( this HttpClient client, string uri, UniversityScheduleClient context )
		{
			return client.GetHeadersAndStringAsync( uri ).ProcessHeaderAsync( context );
		}

		public static Task<string> ProcessHeaderAsync( this Task<Tuple<HttpResponseHeaders, string>> prevTask, UniversityScheduleClient context )
		{
			return prevTask.ContinueWith( p =>
				{
					var result = p.Result;

					IEnumerable<string> xUnivsLastModifiedHeader;
					if( result.Item1.TryGetValues( UniversityScheduleClient.XUnivsLastModified, out xUnivsLastModifiedHeader ) )
					{
						context.UniverstiesModifiedAt = DateTime.ParseExact( string.Join( " ", xUnivsLastModifiedHeader ), "R", null );
					}

					return p.Result.Item2;
				}, TaskContinuationOptions.OnlyOnRanToCompletion );
		}
	}
}