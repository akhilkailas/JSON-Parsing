package mypc.nijil.sampleparsing;

import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("photos/")
    Call<List<DataModel>> getDatas(@Query("client_id") String clientId);
}
