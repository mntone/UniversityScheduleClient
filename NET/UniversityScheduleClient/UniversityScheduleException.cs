using System;
using System.Net;

namespace Mntone.UniversityScheduleClient
{
	/// <summary>
	/// UniversityScheduleException
	/// </summary>
	public sealed class UniversityScheduleException
		: Exception
	{

		internal UniversityScheduleException( UniversityScheduleExceptionReason reason )
			: base()
		{
			this._Reason = reason;
			this._ErrorCode = -1;
		}

		internal UniversityScheduleException( UniversityScheduleExceptionReason reason, Exception innerException )
			: base( string.Empty, innerException )
		{
			this._Reason = reason;
			this._ErrorCode = -1;
		}

		internal UniversityScheduleException( int errorCode )
		{
			this._Reason = UniversityScheduleExceptionReason.WEB_EXCEPTION;
			this._ErrorCode = errorCode;
		}

		/// <summary>
		/// Error reason
		/// </summary>
		public UniversityScheduleExceptionReason Reason { get { return this._Reason; } }
		private readonly UniversityScheduleExceptionReason _Reason;

		/// <summary>
		/// Error code (for WEB_EXCEPTION)
		/// </summary>
		public int ErrorCode { get { return this._ErrorCode; } }
		private readonly int _ErrorCode;
	}
}