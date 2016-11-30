package com.rmsi.android.mast.burkino_faso.adapter;


import java.util.List;

import com.rmsi.android.mast.activity.R;
import com.rmsi.android.mast.burkino_faso.activity.MediaListActivity;
import com.rmsi.android.mast.burkino_faso.activity.PersonListActivity;


import com.rmsi.android.mast.burkino_faso.domain.Attribute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * @author Amreen.S
 *
 */
public class CustomArrayAdapter extends ArrayAdapter<Attribute> {

	private Context context;
	private List<Attribute> myObjs;
	private LayoutInflater lInflator;
	int selectedPosition = -1;
	String classname;
	Object activityObj;

	public CustomArrayAdapter(Context context, Object activityObj, int textViewResourceId, List<Attribute> nextOfKin,String classname) 
	{
		super(context, textViewResourceId, nextOfKin);
		this.context = context;
		this.myObjs = nextOfKin;
		this.lInflator = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.classname = classname;
		this.activityObj = activityObj;
	}

	public int getCount(){
		return myObjs.size();
	}

	public Attribute getItem(int position)
	{
		return myObjs.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ViewHolderItem viewHolder;

		if(convertView==null)
		{
			convertView = lInflator.inflate(R.layout.item_of_custom_array_dapter,parent,false);

			viewHolder = new ViewHolderItem();
			viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.labelName);
			viewHolder.options = (ImageButton) convertView.findViewById(R.id.optionsButton);
			viewHolder.options.setTag(position);
			convertView.setTag(viewHolder);
		}
		else
		{
			viewHolder = (ViewHolderItem) convertView.getTag();		   
		}

		viewHolder.textViewItem.setText(myObjs.get(position).getNextOfKinName());
		
		
		viewHolder.options.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				if(classname.equalsIgnoreCase("personlist"))
				{
					PersonListActivity obj = (PersonListActivity) activityObj;
					//obj.showPopupForPOI(v, v.getTag());
				}				
			}
		});
		

			return convertView;
	}

	private static class ViewHolderItem 
	{
		TextView textViewItem;
		ImageButton options;
	}


	public void setSelectedPosition(int selectedPosition) {
		this.selectedPosition = selectedPosition;
	}

}
