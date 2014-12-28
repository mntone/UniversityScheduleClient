using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Campus
	/// </summary>
	[DataContract]
	public sealed class Campus
	{
		private Campus() { }

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
		/// Coordinates
		/// </summary>
		[DataMember( Name = "coordinates", IsRequired = true )]
		public Coordinates Coordinates { get; private set; }
	}
}