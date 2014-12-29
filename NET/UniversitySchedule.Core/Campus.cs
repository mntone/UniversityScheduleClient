using System.Runtime.Serialization;

namespace Mntone.UniversitySchedule.Core
{
	/// <summary>
	/// Campus
	/// </summary>
	[DataContract]
	public sealed class Campus
	{
		private Campus() { }

		/// <summary>
		/// Constructor
		/// </summary>
		/// <param name="id">ID</param>
		/// <param name="screenName">Screen name</param>
		/// <param name="names">Names</param>
		/// <param name="coordinates"><see cref="Coordinates"/></param>
		internal Campus( int id, string screenName, Names names, Coordinates coordinates )
		{
			this.ID = id;
			this.ScreenName = screenName;
			this.Names = names;
			this.Coordinates = coordinates;
		}

		/// <summary>
		/// ID
		/// </summary>
		[DataMember( Name = "id", IsRequired = true )]
		public int ID { get; private set; }

		/// <summary>
		/// Screen name
		/// </summary>
		[DataMember( Name = "screen_name", IsRequired = true )]
		public string ScreenName { get; private set; }

		/// <summary>
		/// Names
		/// </summary>
		[DataMember( Name = "names", IsRequired = true )]
		public Names Names { get; private set; }

		/// <summary>
		/// Coordinates
		/// </summary>
		[DataMember( Name = "coordinates", IsRequired = true )]
		public Coordinates Coordinates { get; private set; }
	}
}