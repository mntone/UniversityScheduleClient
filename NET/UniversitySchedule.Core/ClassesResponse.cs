using System;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Classes
	/// </summary>
	[DataContract]
	public sealed class ClassesResponse
	{
		private ClassesResponse() { }

		/// <summary>
		/// longitude
		/// </summary>
		/// <param name="message">Message</param>
		/// <param name="classes">Classes</param>
		internal ClassesResponse( string message, Class[] classes )
		{
			this.Message = message;
			this.Classes = classes;
		}

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