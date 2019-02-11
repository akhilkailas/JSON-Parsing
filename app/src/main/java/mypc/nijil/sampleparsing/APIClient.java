package mypc.nijil.sampleparsing;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static String BASE_URL = "https://api.unsplash.com/";
    public static Retrofit sRetrofit;
    public static Retrofit getAPIClient(){
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
