package appewtc.masterung.mystech;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class Service extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        ListView listView = (ListView) findViewById(R.id.LivName);
        try {
            GetUser getUser = new GetUser(Service.this);
            getUser.execute();

            String strJSON = getUser.get();
            Log.d("TestV3", "JSON ==>" + strJSON);
            JSONArray jsonArray = new JSONArray(strJSON);

            String[] namestring = new String[jsonArray.length()];
            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                namestring[i] = jsonObject.getString("Nmae");

            } //for

            //Create ListView
            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(Service.this,
                    android.R.layout.simple_list_item_1, namestring);
            listView.setAdapter(stringArrayAdapter);



        } catch (Exception e) {
            Log.d("TestV3", "e Main ==>" + e.toString());
        }

    }  //Main Method


} //Main Class
