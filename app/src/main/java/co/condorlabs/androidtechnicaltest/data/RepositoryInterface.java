package co.condorlabs.androidtechnicaltest.data;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.dto.ResultResponse;
import co.condorlabs.androidtechnicaltest.data.dto.TeamResponse;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public interface RepositoryInterface {


    MutableLiveData<TeamResponse> getTeamInternet(String idLeague) throws Exception;

    List<Team> saveTeamDB(List<Team> teamList) throws Exception;

    MutableLiveData<List<Team>> getTeamDB(String idLeague) throws Exception;

    MutableLiveData<ResultResponse> getResultInternet(String idTeam) throws Exception;

    List<Result> saveResultDB(List<Result> resultList) throws Exception;

    MutableLiveData<List<Result>> getResultDB(String idTeam) throws Exception;
}
