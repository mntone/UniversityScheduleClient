using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Names
	/// </summary>
	[DataContract]
	public sealed class Names
	{
		private Names() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="local">Name in local language</param>
		/// <param name="englishUnitedStates">Name in English (US)</param>
		/// <param name="region">Region of local language</param>
		public Names( string local, string englishUnitedStates, string region )
		{
			this.Local = local;
			this.EnglishUnitedStates = englishUnitedStates;
			this.Region = region;
		}

		/// <summary>
		/// Name in local language
		/// </summary>
		[DataMember( Name = "local" )]
		public string Local { get; private set; }

		/// <summary>
		/// Name in English (US)
		/// </summary>
		[DataMember( Name = "en-us" )]
		public string EnglishUnitedStates { get; private set; }

		/// <summary>
		/// Region of local language
		/// </summary>
		[DataMember( Name = "locale" )]
		public string Region { get; private set; }
	}
}