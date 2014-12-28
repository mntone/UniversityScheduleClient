using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Names
	/// </summary>
	[DataContract]
	public sealed class Names
	{
		private Names() { }

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
	}
}