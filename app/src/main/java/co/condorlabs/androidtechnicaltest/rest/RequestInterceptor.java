package co.condorlabs.androidtechnicaltest.rest;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {


    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request request = chain.request();

        request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .method(request.method(), request.body())
                .build();

        return chain.proceed(request);
    }
}
