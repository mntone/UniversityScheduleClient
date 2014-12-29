using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Coordinates
	/// </summary>
	[DataContract]
	public sealed class Coordinates
	{
		private Coordinates() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="longitude">Longitude</param>
		/// <param name="latitude">Latitude</param>
		internal Coordinates( float longitude, float latitude )
		{
			this.Longitude = longitude;
			this.Latitude = latitude;
		}

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