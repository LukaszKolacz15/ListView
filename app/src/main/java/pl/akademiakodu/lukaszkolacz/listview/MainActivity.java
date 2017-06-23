package pl.akademiakodu.lukaszkolacz.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        To simplerow:
//        list = (ListView) findViewById(R.id.myList);
//        String names[] = {"Oskar", "Adam", "Kacper", "Donald", "Dorota"};


//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.simplerow, R.id.textList, names);
//        list.setAdapter(adapter);

        list = (ListView) findViewById(R.id.myList);


        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Oskar", "Mikołaj", 20));
        personList.add(new Person("Mateusz", "Rej", 22));
        personList.add(new Person("Sandra", "Polak", 18));
        personList.add(new Person("Mati", "Nowak", 70));


        MyAdapter myAdapter = new MyAdapter(this, personList);
        list.setAdapter(myAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Kliknięto: " + position, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
