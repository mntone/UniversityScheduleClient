package mntone.univschedule.demo.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CustomAdapter<T> extends BaseAdapter
{
	private final T[] _items;
	private final int _layoutId;

	private LayoutInflater _layoutInflater;

	public CustomAdapter( Context context, T[] items, int layoutId )
	{
		this._items = items;
		this._layoutId = layoutId;

		this._layoutInflater = LayoutInflater.from( context );
	}

	@Override
	public int getCount()
	{
		return this._items.length;
	}

	@Override
	public Object getItem( int position )
	{
		return this._items[position];
	}

	@Override
	public long getItemId( int position )
	{
		return position;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent )
	{
		final T data = this._items[position];
		final View view = this._layoutInflater.inflate( this._layoutId, parent, false );
		onViewInitializing( data, view );
		convertView = view;
		return convertView;
	}

	public abstract void onViewInitializing( T data, View targetView );
}