using System;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// PeriodInfo
	/// </summary>
	[DataContract]
	public sealed class PeriodInfo
	{
		private const string TIME_FORMAT = "HH':'mmzz";

		private PeriodInfo() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="from">From</param>
		/// <param name="to">To</param>
		internal PeriodInfo( DateTime from, DateTime to )
		{
			this.From = from;
			this.To = to;
		}

		/// <summary>
		/// From
		/// </summary>
		public DateTime From { get; private set; }

		[DataMember( Name = "from", IsRequired = true )]
		[DebuggerBrowsable( DebuggerBrowsableState.Never )]
		private String FromImpl
		{
			get { return this.From.ToString( TIME_FORMAT ); }
			set { this.From = DateTime.ParseExact( value, TIME_FORMAT, null ); }
		}

		/// <summary>
		/// To
		/// </summary>
		public DateTime To { get; private set; }

		[DataMember( Name = "to", IsRequired = true )]
		[DebuggerBrowsable( DebuggerBrowsableState.Never )]
		private String ToImpl
		{
			get { return this.To.ToString( TIME_FORMAT ); }
			set { this.To = DateTime.ParseExact( value, TIME_FORMAT, null ); }
		}
	}
}