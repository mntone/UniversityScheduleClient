using System.Runtime.Serialization;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// Period
	/// </summary>
	[DataContract]
	public sealed class Period
	{
		private Period() { }

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