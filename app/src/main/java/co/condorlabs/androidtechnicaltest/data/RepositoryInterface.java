package co.condorlabs.androidtechnicaltest.data;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public interface RepositoryInterface {

    List<Team> saveTeamDB(List<Team> teamList) throws Exception;

    List<Result> saveNextEvent(List<Result> resultList) throws Exception;
}
