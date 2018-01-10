package com.globant.mvpweatherapp.io;

import com.globant.mvpweatherapp.constants.IOConstants;
import com.globant.mvpweatherapp.io.api.APIService;
import com.globant.mvpweatherapp.io.deserealizer.DailyDeserializer;
import com.globant.mvpweatherapp.io.deserealizer.LiteWeatherDeserealizer;
import com.globant.mvpweatherapp.io.deserealizer.WeatherDeserealizer;
import com.globant.mvpweatherapp.model.Weather;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adoniram.dominguez on 22/06/2017.
 */

public class ServiceAdapter {

    public APIService searchWeatherFor(final Gson gson){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                String jsonRaw = convertStreamToString(response.body().byteStream());
                jsonRaw = cleanJson(jsonRaw);

                MediaType contentType = response.body().contentType();
                ResponseBody body = ResponseBody.create(contentType, jsonRaw);

                return response.newBuilder().body(body).build();
            }
        });
        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IOConstants.BASE_URI_CITY)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        return retrofit.create(APIService.class);
    }

    public APIService getWeatherForId(final Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IOConstants.BASE_URL_API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(APIService.class);
    }

    public APIService getdailyWeatherForId(final Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IOConstants.BASE_URI_CITY)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(APIService.class);
    }

    public Gson buildLiteWeatherDeserializator(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LiteWeatherResponse.class, new LiteWeatherDeserealizer());
        return gsonBuilder.create();
    }

    public Gson buildWeatherDeserializator(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Weather.class, new WeatherDeserealizer());
        return gsonBuilder.create();
    }

    public Gson buildDailyWeatherDeserializator(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DailyWeatherResponse.class, new DailyDeserializer());
        return gsonBuilder.create();
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private String cleanJson(String json){
        String result = "";
        if(json == null){
            return null;
        } else {
            if(json.length() > 0){
                String[] dirtyJson = json.split("\\(");
                String tempJson = dirtyJson[1].trim();
                tempJson = tempJson.substring(0, tempJson.length() -1);

                result = tempJson;
            } else {

            }
            return  result;
        }
    }
}
