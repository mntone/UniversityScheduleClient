using System;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Class
	/// </summary>
	[DataContract]
	public sealed class Class
	{
		private const string DATE_FORMAT = "yyyy'-'MM'-'dd";

		private Class() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="hash">Hash</param>
		/// <param name="date">Date</param>
		/// <param name="period"><see cref="Period"/></param>
		/// <param name="campusName">Campus name</param>
		/// <param name="department">Department</param>
		/// <param name="subject">Subject</param>
		/// <param name="lecturer">Lecturer</param>
		/// <param name="grade">Grade</param>
		/// <param name="note">Note</param>
		internal Class( string hash, DateTime date, Period period, string campusName, string department, string subject, string lecturer, string grade, string note )
		{
			this.Hash = hash;
			this.Date = date;
			this.Period = period;
			this.CampusName = campusName;
			this.Department = department;
			this.Subject = subject;
			this.Lecturer = lecturer;
			this.Grade = grade;
			this.Note = note;
		}

		/// <summary>
		/// Hash
		/// </summary>
		[DataMember( Name = "hash", IsRequired = true )]
		public string Hash { get; private set; }

		/// <summary>
		/// Date
		/// </summary>
		public DateTime Date { get; private set; }

		[DataMember( Name = "date", IsRequired = true )]
		private String DateImpl
		{
			get { return this.Date.ToString( DATE_FORMAT ); }
			set { this.Date = DateTime.ParseExact( value, DATE_FORMAT, null ); }
		}

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