using System;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Universities
	/// </summary>
	[DataContract]
	public sealed class UniversitiesResponse
	{
		private UniversitiesResponse() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="message">Error message</param>
		/// <param name="universities">Array of <see cref="University"/></param>
		/// <param name="modifiedAt">Last modified</param>
		internal UniversitiesResponse( string message, University[] universities, DateTime modifiedAt )
		{
			this.Message = message;
			this.Universities = universities;
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
		/// Array of <see cref="University"/>
		/// </summary>
		[DataMember( Name = "items", IsRequired = true )]
		public University[] Universities { get; private set; }

		/// <summary>
		/// Last modified
		/// </summary>
		[DataMember( Name = "last_update", IsRequired = true )]
		public DateTime ModifiedAt { get; private set; }
	}
}