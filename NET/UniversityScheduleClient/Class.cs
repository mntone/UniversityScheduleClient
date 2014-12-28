using System;
using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Class
	/// </summary>
	[DataContract]
	public sealed class Class
	{
		private Class() { }

		/// <summary>
		/// ID
		/// </summary>
		[DataMember( Name = "hash", IsRequired = true )]
		public string ID { get; private set; }

		/// <summary>
		/// Period
		/// </summary>
		[DataMember( Name = "period", IsRequired = true )]
		public Period Period { get; private set; }

		/// <summary>
		/// Campus name
		/// </summary>
		[DataMember( Name = "campus_name" )]
		public string CampusName { get; private set; }

		/// <summary>
		/// Department
		/// </summary>
		[DataMember( Name = "department" )]
		public string Department { get; private set; }

		/// <summary>
		/// Subject
		/// </summary>
		[DataMember( Name = "subject", IsRequired = true )]
		public string Subject { get; private set; }

		/// <summary>
		/// Lecturer
		/// </summary>
		[DataMember( Name = "lecturer", IsRequired = true )]
		public string Lecturer { get; private set; }

		/// <summary>
		/// Grade
		/// </summary>
		[DataMember( Name = "grade" )]
		public string Grade { get; private set; }

		/// <summary>
		/// Note message
		/// </summary>
		[DataMember( Name = "note" )]
		public string Note { get; private set; }
	}
}