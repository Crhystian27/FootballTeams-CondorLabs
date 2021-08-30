package co.condorlabs.androidtechnicaltest.di.module;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import javax.inject.Singleton;

import co.condorlabs.androidtechnicaltest.data.CondorLabsDataBase;
import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class DBModule {

    private static final String DATA_BASE_NAME = "CondorLabs01.db";

    @Provides
    @Singleton
    CondorLabsDataBase provideDataBase(Application application) {
        return Room.databaseBuilder(application,
                CondorLabsDataBase.class, DATA_BASE_NAME)
                .allowMainThreadQueries().addCallback(new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                    }
                }).build();
    }
}
