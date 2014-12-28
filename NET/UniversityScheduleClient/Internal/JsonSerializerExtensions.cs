using System;
using System.IO;
using System.Runtime.Serialization.Json;
using System.Text;

namespace Mntone.UniversityScheduleClient.Internal
{
	internal static class JsonSerializerExtensions
	{
		public static T Load<T>( string data )
		{
			using( var ms = new MemoryStream( Encoding.Unicode.GetBytes( data ) ) )
			{
				return ( T )new DataContractJsonSerializer( typeof( T ) ).ReadObject( ms );
			}
			throw new UniversityScheduleException( UniversityScheduleExceptionReason.PARSE_FAILED );
		}
	}
}