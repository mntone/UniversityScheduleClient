using System;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Coordinates
	/// </summary>
	[DataContract]
	[DebuggerDisplay( "{StringView()}" )]
	public sealed class Coordinates
	{
		private Coordinates() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="latitude">Latitude</param>
		/// <param name="longitude">Longitude</param>
		internal Coordinates( float latitude, float longitude )
		{
			this.Latitude = latitude;
			this.Longitude = longitude;
		}

		/// <summary>
		/// Latitude
		/// </summary>
		[DataMember( Name = "latitude", IsRequired = true )]
		public float Latitude { get; private set; }

		/// <summary>
		/// Longitude
		/// </summary>
		[DataMember( Name = "longitude", IsRequired = true )]
		public float Longitude { get; private set; }

		private string StringView()
		{
			var absLatitude = Math.Abs( this.Latitude );
			var absLongitude = Math.Abs( this.Longitude );
			var latitudeDegrees = ( uint )absLatitude;
			var longitudeDegrees = ( uint )absLongitude;
			var latitudeMinutesF = 60 * ( absLatitude - latitudeDegrees );
			var longitudeMinutesF = 60 * ( absLongitude - longitudeDegrees );
			var latitudeMinutes = ( uint )latitudeMinutesF;
			var longitudeMinutes = ( uint )longitudeMinutesF;
			var latitudeSeconds = 60 * ( latitudeMinutesF - latitudeMinutes );
			var longitudeSeconds = 60 * ( longitudeMinutesF - longitudeMinutes );
			var charLatitude = this.Latitude > 0 ? 'N' : 'S';
			var charLongitude = this.Latitude > 0 ? 'E' : 'W';
			return string.Format(
				"{0}°{1}'{2:0.000}\"{3}, {4}°{5}'{6:0.000}\"{7}",
				latitudeDegrees, latitudeMinutes, latitudeSeconds, charLatitude,
				longitudeDegrees, longitudeMinutes, longitudeSeconds, charLongitude );
		}
	}
}