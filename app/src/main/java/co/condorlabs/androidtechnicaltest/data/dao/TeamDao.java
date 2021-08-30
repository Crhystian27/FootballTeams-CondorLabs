package co.condorlabs.androidtechnicaltest.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

@Dao
public interface TeamDao {

    @Query("SELECT * from team_table WHERE idLeague =:idLeague")
    List<Team> getIdLeague(String idLeague);

    @Query("DELETE FROM team_table")
    void deleteAllTeam();

    @Query("SELECT * FROM team_table WHERE idTeam =:idTeam")
    boolean compareTo(String idTeam);

    @Update(entity = Result.class)
    void updateResult(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTeam(List<Team> team);
}
