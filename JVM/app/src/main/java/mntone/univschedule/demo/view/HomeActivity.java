package mntone.univschedule.demo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import mntone.univschedule.core.*;
import mntone.univschedule.core.Class;
import mntone.univschedule.demo.R;
import mntone.univschedule.demo.core.UnivScheduleAppContext;

public class HomeActivity extends Activity
{
	static final String KEY_UNIVERSITY_SCREEN_NAME = "UNIVERSITY_SCREEN_NAME";
	static final String KEY_CLASS_HASH = "CLASS_HASH";

	private UnivScheduleAppContext _context;

	public HomeActivity()
	{
		super();

		this._context = UnivScheduleAppContext.getContext();
	}

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_home );

		final ListView listView = ( ListView )this.findViewById( android.R.id.list );

		final Intent intent = getIntent();
		if( intent.hasExtra( KEY_UNIVERSITY_SCREEN_NAME ) )
		{
			final String usn = intent.getStringExtra( KEY_UNIVERSITY_SCREEN_NAME );
			listView.setOnItemClickListener(
				( parent, view, pos, id ) ->
				{
					final Class data = ( Class )listView.getItemAtPosition( pos );
					final Intent newIntent = new Intent( getApplication(), DetailActivity.class );
					newIntent.putExtra( KEY_UNIVERSITY_SCREEN_NAME, usn );
					newIntent.putExtra( KEY_CLASS_HASH, data.getHash() );
					startActivity( newIntent );
				} );

			this._context.getClassesAsync( usn ).done(
				result ->
				{
					final CustomAdapter<Class> universitiesAdapter = new CustomAdapter<Class>( this, result.getClasses(), R.layout.item )
					{
						@Override
						public void onViewInitializing( Class data, View targetView )
						{
							final LinearLayout view = ( LinearLayout )targetView;
							final TextView titleTextView = ( TextView )view.findViewById( android.R.id.title );
							titleTextView.setText( data.getSubject() );
							final TextView summaryTextView = ( TextView )view.findViewById( android.R.id.summary );
							summaryTextView.setText( data.getLecturer() );
						}
					};
					listView.setAdapter( universitiesAdapter );
				} );
		}
		else
		{
			listView.setOnItemClickListener(
				( parent, view, pos, id ) ->
				{
					final University data = ( University )listView.getItemAtPosition( pos );
					final Intent newIntent = new Intent( getApplication(), HomeActivity.class );
					newIntent.putExtra( KEY_UNIVERSITY_SCREEN_NAME, data.getScreenName() );
					startActivity( newIntent );
				} );

			this._context.getUniversitiesAsync().done(
				result ->
				{
					final CustomAdapter<University> universitiesAdapter = new CustomAdapter<University>(
						this,
						result.getUniversities(),
						R.layout.item )
					{
						@Override
						public void onViewInitializing( University data, View targetView )
						{
							final LinearLayout view = ( LinearLayout )targetView;
							final TextView titleTextView = ( TextView )view.findViewById( android.R.id.title );
							titleTextView.setText( data.getNames().getLocal() );
							final TextView summaryTextView = ( TextView )view.findViewById( android.R.id.summary );
							summaryTextView.setText( data.getScreenName() );
						}
					};
					listView.setAdapter( universitiesAdapter );
				} );
		}
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu )
	{
		getMenuInflater().inflate( R.menu.menu_home, menu );
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item )
	{
		int id = item.getItemId();
		if( id == R.id.action_settings )
		{
			return true;
		}
		return super.onOptionsItemSelected( item );
	}
}
