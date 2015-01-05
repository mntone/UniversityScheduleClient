using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;
using System.Text;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal static class JsonSerializerExtensions
	{
		public static T Load<T>( string data )
		{
			using( var ms = new MemoryStream( Encoding.Unicode.GetBytes( data ) ) )
			{
				return ( T )new DataContractJsonSerializer( typeof( T ), new DataContractJsonSerializerSettings
				{
					DateTimeFormat = new DateTimeFormat( "yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'" ),
					UseSimpleDictionaryFormat = true,
				} ).ReadObject( ms );
			}
			throw new UniversityScheduleException( UniversityScheduleExceptionReason.PARSE_FAILED );
		}
	}
}