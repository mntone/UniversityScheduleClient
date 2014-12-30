using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal class BaseClient<T>
	{
		private static T ParseData( string data )
		{
			return JsonSerializerExtensions.Load<T>( data );
		}

		public static Task<T> GetAsync( UniversityScheduleClient context, string url )
		{
			return context
				.GetStringWithHeaderProcessingAsync( url )
				.ContinueWith( prevTask => ParseData( prevTask.Result ), TaskContinuationOptions.OnlyOnRanToCompletion );
		}
	}
}