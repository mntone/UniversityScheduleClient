using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// University
	/// </summary>
	[DataContract]
	public sealed class University
	{
		private University() { }

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