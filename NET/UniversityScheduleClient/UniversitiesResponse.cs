using System;
using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Universities
	/// </summary>
	[DataContract]
	public sealed class UniversitiesResponse
	{
		private UniversitiesResponse() { }

		/// <summary>
		/// Error message
		/// </summary>
		/// <remarks>
		/// Has message when error occurs.
		/// </remarks>
		[DataMember( Name = "message" )]
		public string Message { get; private set; }

		/// <summary>
		/// Array of <see cref="University"/>
		/// </summary>
		[DataMember( Name = "items", IsRequired = true )]
		public University[] Universities { get; private set; }
	}
}