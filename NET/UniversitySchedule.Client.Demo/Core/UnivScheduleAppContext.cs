using Mntone.UniversitySchedule.Core;
using Mntone.UniversitySchedule.Client;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Demo.Core
{
	public sealed class UnivScheduleAppContext
	{
		public static UnivScheduleAppContext Context
		{
			get { return _Context ?? ( _Context = new UnivScheduleAppContext() ); }
		}
		private static UnivScheduleAppContext _Context;


		private readonly UniversityScheduleClient _client;

		private UniversitiesResponse _universities;
		private Dictionary<string, ClassesResponse> _classesMap = new Dictionary<string, ClassesResponse>();

		private UnivScheduleAppContext()
		{
			this._client = new UniversityScheduleClient( "testing123" );
		}

		public Task<UniversitiesResponse> GetUniverstiesAsync()
		{
			if( this._universities != null )
			{
				return Task.FromResult( this._universities );
			}
			return this._client.GetUniversitiesAsync();
		}

		public Task<ClassesResponse> GetClassesAsync( string screenName )
		{
			if( this._classesMap.ContainsKey( screenName ) )
			{
				return Task.FromResult( this._classesMap[screenName] );
			}
			return this._client.GetClassesAsync( screenName );
		}
	}
}