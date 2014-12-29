using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// University
	/// </summary>
	[DataContract]
	public sealed class University
	{
		private University() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="id">ID</param>
		/// <param name="screenName">Screen name</param>
		/// <param name="names">Names</param>
		/// <param name="campuses">Array of <see cref="Campus"/></param>
		internal University( int id, string screenName, Names names, Campus[] campuses )
		{
			this.ID = id;
			this.ScreenName = screenName;
			this.Names = names;
			this.Campuses = campuses;
		}

		/// <summary>
		/// ID
		/// </summary>
		[DataMember( Name = "id", IsRequired = true )]
		public int ID { get; private set; }

		/// <summary>
		/// Screen name
		/// </summary>
		[DataMember( Name = "screen_name", IsRequired = true )]
		public string ScreenName { get; private set; }

		/// <summary>
		/// Names
		/// </summary>
		[DataMember( Name = "names", IsRequired = true )]
		public Names Names { get; private set; }

		/// <summary>
		/// Campuses
		/// </summary>
		[DataMember( Name = "campuses" )]
		public Campus[] Campuses { get; private set; }
	}
}