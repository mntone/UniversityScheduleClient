using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal class BaseClient<T>
	{
		private T ParseData( string data )
		{
			return JsonSerializerExtensions.Load<T>( data );
		}

		protected virtual Task<string> GetStringAsync( UniversityScheduleClient context, string url )
		{
			return context.GetStringWithHeaderProcessingAsync( url );
		}

		public Task<T> GetAsync( UniversityScheduleClient context, string url )
		{
			return GetStringAsync( context, url )
				.ContinueWith( prevTask => ParseData( prevTask.Result ), TaskContinuationOptions.OnlyOnRanToCompletion );
		}
	}
}