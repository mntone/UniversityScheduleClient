using System.Diagnostics;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Names
	/// </summary>
	[DataContract]
	[DebuggerDisplay( "{English}" )]
	public sealed class Names
	{
		private Names() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="local">Name in local language</param>
		/// <param name="english">Name in English</param>
		/// <param name="language">Local language</param>
		public Names( string local, string english, string language )
		{
			this.Local = local;
			this.English = english;
			this.Language = language;
		}

		/// <summary>
		/// Name in local language
		/// </summary>
		[DataMember( Name = "local" )]
		public string Local { get; private set; }

		/// <summary>
		/// Name in English
		/// </summary>
		[DataMember( Name = "english" )]
		public string English { get; private set; }

		/// <summary>
		/// Local language (ISO 639-1)
		/// </summary>
		[DataMember( Name = "language" )]
		public string Language { get; private set; }
	}
}