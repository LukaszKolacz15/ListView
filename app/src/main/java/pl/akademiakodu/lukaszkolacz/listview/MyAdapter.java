package pl.akademiakodu.lukaszkolacz.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.name;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Lukasz Kolacz on 23.06.2017.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Person> personList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.customrow, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.textName);
            viewHolder.lastname = (TextView) convertView.findViewById(R.id.textLastname);
            viewHolder.age = (TextView) convertView.findViewById(R.id.textAge);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(personList.get(position).getName());
        viewHolder.lastname.setText(personList.get(position).getLastname());
        viewHolder.age.setText("Wiek: " + personList.get(position).getAge());

        return convertView;
    }


    class ViewHolder {
        TextView name;
        TextView lastname;
        TextView age;
    }
}
