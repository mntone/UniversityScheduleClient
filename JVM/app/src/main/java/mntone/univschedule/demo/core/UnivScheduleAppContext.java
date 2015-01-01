package mntone.univschedule.demo.core;

import org.jdeferred.Promise;
import org.jdeferred.android.AndroidDeferredManager;

import java.util.HashMap;

import mntone.univschedule.core.*;
import mntone.univschedule.client.UniversityScheduleClient;

public final class UnivScheduleAppContext
{
	private static UnivScheduleAppContext _context;

	public static UnivScheduleAppContext getContext()
	{
		if( _context == null )
		{
			_context = new UnivScheduleAppContext();
		}
		return _context;
	}

	private final AndroidDeferredManager _deferredManager;
	private final UniversityScheduleClient _client;

	private UniversitiesResponse _universities = null;
	private HashMap<String, ClassesResponse> _classesMap = null;

	public UnivScheduleAppContext()
	{
		this._deferredManager = new AndroidDeferredManager();
		this._client = new UniversityScheduleClient( "testing123" );

		this._classesMap = new HashMap<>();
	}

	public Promise<UniversitiesResponse, Throwable, Void> getUniversitiesAsync()
	{
		return this._deferredManager.when(
			() ->
			{
				if( this._universities == null )
				{
					this._universities = this._client.getUniversities();
					return this._universities;
				}
				return this._universities;
			} );
	}

	public Promise<ClassesResponse, Throwable, Void> getClassesAsync( final String universityScreenName )
	{
		return this._deferredManager.when(
			() ->
			{
				if( !this._classesMap.containsKey( universityScreenName ) )
				{
					final ClassesResponse classes = this._client.getClasses( universityScreenName );
					this._classesMap.put( universityScreenName, classes );
					return classes;
				}

				return this._classesMap.get( universityScreenName );
			} );
	}
}