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
		/// Constructor
		/// </summary>
		/// <param name="message">Message</param>
		/// <param name="university"><see cref="University"/></param>
		/// <param name="classes">Array of <see cref="Class"/></param>
		/// <param name="modifiedAt">Last modified</param>
		internal ClassesResponse( string message, University university, Class[] classes, DateTime modifiedAt )
		{
			this.Message = message;
			this.University = university;
			this.Classes = classes;
			this.ModifiedAt = modifiedAt;
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
		/// <see cref="University"/>
		/// </summary>
		[DataMember( Name = "university", IsRequired = true )]
		public University University { get; private set; }

		/// <summary>
		/// Array of <see cref="Class"/>
		/// </summary>
		[DataMember( Name = "items", IsRequired = true )]
		public Class[] Classes { get; private set; }

		/// <summary>
		/// Last modified
		/// </summary>
		[DataMember( Name = "modified_at", IsRequired = true )]
		public DateTime ModifiedAt { get; private set; }
	}
}