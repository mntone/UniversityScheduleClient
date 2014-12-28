package mntone.univschedule.demo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import mntone.univscheduleclient.Class;
import mntone.univschedule.demo.R;
import mntone.univschedule.demo.core.UnivScheduleAppContext;

public class DetailActivity extends Activity
{
	private UnivScheduleAppContext _context;

	public DetailActivity()
	{
		super();

		this._context = UnivScheduleAppContext.getContext();
	}

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_detail );

		final Intent intent = getIntent();
		final String usn = intent.getStringExtra( HomeActivity.KEY_UNIVERSITY_SCREEN_NAME );
		final String cid = intent.getStringExtra( HomeActivity.KEY_CLASS_HASH );
		this._context.getClassesAsync( usn ).done(
			result ->
			{
				Class data = null;
				for( Class c : result.getClasses() )
				{
					if( c.getId().compareTo( cid ) == 0 )
					{
						data = c;
						break;
					}
				}
				if( data != null )
				{
					final TextView subjectTextView = ( TextView )this.findViewById( R.id.subject );
					subjectTextView.setText( data.getSubject() );

					final TextView periodTextView = ( TextView )this.findViewById( R.id.period );
					periodTextView.setText( data.getPeriod().getFrom() + "-" + data.getPeriod().getTo() );

					final TextView campusTextView = ( TextView )this.findViewById( R.id.campus );
					campusTextView.setText( data.getCampusName() );

					final TextView noteTextView = ( TextView )this.findViewById( R.id.note );
					noteTextView.setText( data.getNote() );
				}
			} );
	}
}
