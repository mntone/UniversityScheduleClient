using System.Diagnostics;
using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Period
	/// </summary>
	[DataContract]
	[DebuggerDisplay( "{From}-{To}" )]
	public sealed class Period
	{
		private Period() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="from">From</param>
		/// <param name="to">To</param>
		internal Period( byte from, byte to )
		{
			this.From = from;
			this.To = to;
		}

		/// <summary>
		/// From
		/// </summary>
		[DataMember( Name = "from", IsRequired = true )]
		public byte From { get; private set; }

		/// <summary>
		/// To
		/// </summary>
		[DataMember( Name = "to", IsRequired = true )]
		public byte To { get; private set; }
	}
}