using Mntone.UniversitySchedule.Client.Internal;
using Mntone.UniversitySchedule.Core;
using System;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client
{
	/// <summary>
	/// Client for university class schedule
	/// </summary>
	public sealed class UniversityScheduleClient
		: IDisposable
	{
		internal const string XUnivsLastModified = "X-UNIVS-LAST-MODIFIED";
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
			this.AdditionalUserAgent = null;
			this.UniverstiesModifiedAt = DateTime.MinValue;
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
			return new UniversitiesClient().GetAsync( this, url );
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
			return new BaseClient<ClassesResponse>().GetAsync( this, url );
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
					this.AdditionalUserAgent != null
						? DefaultUserAgent + " (" + this.AdditionalUserAgent + ')'
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
		public string AdditionalUserAgent { get; set; }

		/// <summary>
		/// Last modified of university list
		/// </summary>
		public DateTime UniverstiesModifiedAt { get; set; }
	}
}