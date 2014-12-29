
namespace Mntone.UniversitySchedule.Client.Internal
{
	internal static class UniversityScheduleUrls
	{
		public const string BASE_URL = "http://kyuko.catchball.co/";
		public const string API_BASE_URL = BASE_URL + "api/";

		public const string UNIVERSTIES_URL = API_BASE_URL + "1/universities.json?api_key={0}";
		public const string CANCELLATIONS_URL = API_BASE_URL + "1/kyuko.json?api_key={0}&screen_name={1}";
	}
}