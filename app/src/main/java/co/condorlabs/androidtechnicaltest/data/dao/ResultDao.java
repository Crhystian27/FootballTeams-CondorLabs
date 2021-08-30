package co.condorlabs.androidtechnicaltest.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.entity.Result;


@Dao
public interface ResultDao {

    @Query("SELECT * from result_table WHERE idHomeTeam =:idHomeTeam")
    LiveData<List<Result>> getIdResult(Integer idHomeTeam);

    @Query("DELETE FROM result_table")
    void deleteAllResult();

    @Update(entity = Result.class)
    void updateResult(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllResult(List<Result> resultList);
}
