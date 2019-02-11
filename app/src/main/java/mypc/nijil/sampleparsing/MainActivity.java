package mypc.nijil.sampleparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "myApp";
    APIInterface retroAPI;
    TextView tv;
    List<DataModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.hello);
        Retrofit retrofit = APIClient.getAPIClient();
        retroAPI = retrofit.create(APIInterface.class);
        Call<List<DataModel>> call = retroAPI.getDatas("51028988dcd22b619f5d5e952ecbe3c9e6379ae7d8988467fad1523c9f75d22b");
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                dataList = response.body();
                Log.d(TAG, "onResponse: " + dataList.get(0).getColor());
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);

            }
        });
    }
}
