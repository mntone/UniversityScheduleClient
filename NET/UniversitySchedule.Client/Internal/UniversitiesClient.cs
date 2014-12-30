using Mntone.UniversitySchedule.Core;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Mntone.UniversitySchedule.Client.Internal
{
	internal sealed class UniversitiesClient: BaseClient<UniversitiesResponse>
	{
		protected override Task<string> GetStringAsync( UniversityScheduleClient context, string url )
		{
			return context.GetClient().GetHeadersAndStringAsync( url ).ContinueWith( p =>
			{
				var result = p.Result;

				IEnumerable<string> lastModifiedHeader;
				if( result.Item1.TryGetValues( "LAST-MODIFIED", out lastModifiedHeader ) )
				{
					context.UniverstiesModifiedAt = DateTime.ParseExact( string.Join( " ", lastModifiedHeader ), "R", null );
				}

				return p.Result.Item2;
			}, TaskContinuationOptions.OnlyOnRanToCompletion );
		}
	}
}