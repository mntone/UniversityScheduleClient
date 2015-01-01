using System;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Classes
	/// </summary>
	[DataContract]
	public sealed class ClassResponse
	{
		private ClassResponse() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="message">Message</param>
		/// <param name="university"><see cref="University"/></param>
		/// <param name="klass"><see cref="Class"/></param>
		/// <param name="modifiedAt">Last modified</param>
		internal ClassResponse( string message, University university, Class klass, DateTime modifiedAt )
		{
			this.Message = message;
			this.University = university;
			this.Class = klass;
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
		/// <see cref="Class"/>
		/// </summary>
		[DataMember( Name = "item", IsRequired = true )]
		public Class Class { get; private set; }

		/// <summary>
		/// Last modified
		/// </summary>
		[DataMember( Name = "modified_at", IsRequired = true )]
		public DateTime ModifiedAt { get; private set; }
	}
}