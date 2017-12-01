package com.smile.mohamed.mvpexample.extra;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.TextView;


        import com.smile.mohamed.mvpexample.R;
        import com.smile.mohamed.mvpexample.model.Student;

        import java.util.ArrayList;


public class Adapter extends BaseAdapter {

    static ArrayList<Student> list;
    static Context      context;
    public Adapter(Context context , ArrayList<Student> list )
    {
        this.list    = list;
        this.context = context;

    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Student getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null )
        {
            convertView = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item,parent, false);

        }

        String id = list.get(position).getId();
        String name = list.get(position).getName();
        String address = list.get(position).getAddress();
        String grade = list.get(position).getGrade();
        TextView TEXT_ID = (TextView) convertView.findViewById(R.id.item_id);
        TextView TEXT_NAME     = (TextView)  convertView.findViewById(R.id.item_name);
        TextView TEXT_ADDRESS = (TextView) convertView.findViewById(R.id.item_Address);
        TextView TEXT_GRADE     = (TextView)  convertView.findViewById(R.id.item_grade);


        TEXT_ID.setText(id);
        TEXT_NAME.setText(name);
        TEXT_ADDRESS.setText(address);
        TEXT_GRADE.setText(grade);

        return convertView;
    }
}
