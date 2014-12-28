package mntone.univscheduleclient;

class UniversityScheduleUrls
{
	public static final String BASE_URL = "http://kyuko.catchball.co/";
	public static final String API_BASE_URL = BASE_URL + "api/";

	public static final String UNIVERSTIES_URL = API_BASE_URL + "1/universities.json?api_key=%s";
	public static final String CANCELLATIONS_URL = API_BASE_URL + "1/kyuko.json?api_key=%s&screen_name=%s";
}