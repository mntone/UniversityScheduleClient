using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Coordinates
	/// </summary>
	[DataContract]
	public sealed class Coordinates
	{
		private Coordinates() { }

		/// <summary>
		/// Longitude
		/// </summary>
		[DataMember( Name = "longitude", IsRequired = true )]
		public float Longitude { get; private set; }

		/// <summary>
		/// Latitude
		/// </summary>
		[DataMember( Name = "latitude", IsRequired = true )]
		public float Latitude { get; private set; }
	}
}