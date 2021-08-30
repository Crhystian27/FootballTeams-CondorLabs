package co.condorlabs.androidtechnicaltest.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import co.condorlabs.androidtechnicaltest.converter.DataTypeConverter;
import co.condorlabs.androidtechnicaltest.data.dao.ResultDao;
import co.condorlabs.androidtechnicaltest.data.dao.TeamDao;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

@Database(entities = {Team.class, Result.class},
        version = 1,
        exportSchema = false)

@TypeConverters({DataTypeConverter.class})
public abstract class CondorLabsDataBase extends RoomDatabase {

    public abstract TeamDao teamDao();

    public abstract ResultDao resultDao();
}
