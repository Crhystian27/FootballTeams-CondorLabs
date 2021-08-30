package co.condorlabs.androidtechnicaltest.di.module;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import co.condorlabs.androidtechnicaltest.data.Repository;
import co.condorlabs.androidtechnicaltest.rest.ApiService;
import co.condorlabs.androidtechnicaltest.data.CondorLabsDataBase;
import co.condorlabs.androidtechnicaltest.data.dao.ResultDao;
import co.condorlabs.androidtechnicaltest.data.dao.TeamDao;
import co.condorlabs.androidtechnicaltest.rest.LoggingInterceptor;
import co.condorlabs.androidtechnicaltest.rest.RequestInterceptor;
import co.condorlabs.androidtechnicaltest.util.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Repository provideRepository(ApiService apiService, Executor executor, TeamDao teamDao, ResultDao resultDao) {
        return new Repository(apiService, executor, teamDao, resultDao);
    }

    @Provides
    @Singleton
    Executor providesExecutor() {
        return Executors.newSingleThreadExecutor();
    }


    @Provides
    @Singleton
    TeamDao provideTeamDao(CondorLabsDataBase dataBase) {
        return dataBase.teamDao();
    }

    @Provides
    @Singleton
    ResultDao provideResultDao(CondorLabsDataBase dataBase) {
        return dataBase.resultDao();
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient.Builder().connectTimeout(Constants.REQUEST_TIMEOUT, TimeUnit.SECONDS);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(OkHttpClient.Builder okHttpClientBuilder) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder.addNetworkInterceptor(new LoggingInterceptor());
        okHttpClientBuilder.addInterceptor(new HttpLoggingInterceptor());
        okHttpClientBuilder.addInterceptor(new RequestInterceptor());

        return okHttpClientBuilder.cache(null).build();

    }

    @Provides
    @Singleton
    static Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
    }


    @Provides
    @Singleton
    ApiService providesService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}
