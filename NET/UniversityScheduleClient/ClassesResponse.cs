using System;
using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Classes
	/// </summary>
	[DataContract]
	public sealed class ClassesResponse
	{
		private ClassesResponse() { }

		/// <summary>
		/// Error message
		/// </summary>
		/// <remarks>
		/// Has message when error occurs.
		/// </remarks>
		[DataMember( Name = "message" )]
		public string Message { get; private set; }

		/// <summary>
		/// Array of <see cref="Class"/>
		/// </summary>
		[DataMember( Name = "items", IsRequired = true )]
		public Class[] Classes { get; private set; }
	}
}