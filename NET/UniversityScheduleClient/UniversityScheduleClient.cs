using System;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Mntone.UniversityScheduleClient.Internal;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Client for university class schedule
	/// </summary>
	public sealed class UniversityScheduleClient
		: IDisposable
	{
		internal const string DefaultUserAgent = "UniversityScheduleClient for .NET/0.9";

		private HttpClientHandler _httpClientHandler = null;
		private HttpClient _httpClient = null;

		/// <summary>
		/// Initialize a new client for university class schedule.
		/// </summary>
		/// <param name="accessKey">Access key</param>
		public UniversityScheduleClient( string accessKey )
		{
			this._AccessKey = accessKey;
		}

		/// <summary>
		/// Dispose
		/// </summary>
		public void Dispose()
		{
			if( this._httpClient != null )
			{
				if( this._httpClientHandler != null )
				{
					this._httpClientHandler.Dispose();
					this._httpClientHandler = null;
				}

				this._httpClient.Dispose();
				this._httpClient = null;
			}
		}

		/// <summary>
		/// Get universities.
		/// </summary>
		/// <returns>The array of <see cref="University"/></returns>
		public Task<UniversitiesResponse> GetUniversitiesAsync()
		{
			var url = string.Format( UniversityScheduleUrls.UNIVERSTIES_URL, this.AccessKey );
			return BaseClient<UniversitiesResponse>.GetAsync( this, url );
		}

		/// <summary>
		/// Get classes.
		/// </summary>
		/// <returns>The array of <see cref="Class"/></returns>
		public Task<ClassesResponse> GetClassesAsync( University university )
		{
			return GetClassesAsync( university.ScreenName );
		}

		/// <summary>
		/// Get classes.
		/// </summary>
		/// <returns>The array of <see cref="Class"/></returns>
		public Task<ClassesResponse> GetClassesAsync( string universityScreenName )
		{
			var url = string.Format( UniversityScheduleUrls.CANCELLATIONS_URL, this.AccessKey, universityScreenName );
			return BaseClient<ClassesResponse>.GetAsync( this, url );
		}

		internal HttpClient GetClient()
		{
			if( this._httpClient == null )
			{
				this._httpClientHandler = new HttpClientHandler();
				this._httpClientHandler.AllowAutoRedirect = false;
				this._httpClientHandler.AutomaticDecompression = DecompressionMethods.Deflate | DecompressionMethods.GZip;
				this._httpClient = new HttpClient( this._httpClientHandler, false );
				this._httpClient.DefaultRequestHeaders.Add(
					"user-agent",
					this._AdditionalUserAgent != null
						? DefaultUserAgent + " (" + this._AdditionalUserAgent + ')'
						: DefaultUserAgent );
				this._httpClient.Timeout = TimeSpan.FromSeconds( 5 );
			}
			return this._httpClient;
		}

		/// <summary>
		/// Access key
		/// </summary>
		public string AccessKey
		{
			get { return this._AccessKey; }
		}
		private readonly string _AccessKey = null;

		/// <summary>
		/// Additional user agent
		/// </summary>
		public string AdditionalUserAgent
		{
			get { return this._AdditionalUserAgent; }
			set { this._AdditionalUserAgent = value; }
		}
		private string _AdditionalUserAgent = null;
	}
}