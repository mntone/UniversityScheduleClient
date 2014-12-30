using System;
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
			return prevTask.ContinueWith( p => p.Result.Item2, TaskContinuationOptions.OnlyOnRanToCompletion );
		}
	}
}