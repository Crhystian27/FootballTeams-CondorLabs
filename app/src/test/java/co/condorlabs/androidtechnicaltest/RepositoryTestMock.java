package co.condorlabs.androidtechnicaltest;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import co.condorlabs.androidtechnicaltest.data.RepositoryInterface;
import co.condorlabs.androidtechnicaltest.data.dto.ResultResponse;
import co.condorlabs.androidtechnicaltest.data.dto.TeamResponse;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public class RepositoryTestMock implements RepositoryInterface {


    @Override
    public MutableLiveData<TeamResponse> getTeamInternet(String idLeague) throws Exception {
        MutableLiveData<TeamResponse> teamResponse = new MutableLiveData<>();
        teamResponse.setValue(null);
        //Todo how Mock Rest?
        throw new Exception("La lista no puede estar null");
    }

    @Override
    public List<Team> saveTeamDB(List<Team> teamList) throws Exception {
        if (teamList == null) {
            throw new Exception("La lista no puede estar null");
        } else if (teamList.isEmpty()) {
            throw new Exception("La lista no puede estar vacia");
        }
        return teamList;
    }

    @Override
    public MutableLiveData<List<Team>> getTeamDB(String idLeague) throws Exception {
        MutableLiveData<List<Team>> team = new MutableLiveData<>();
        team.setValue(teamMock());
        throw new Exception("La lista no puede estar null");
    }

    @Override
    public MutableLiveData<List<Result>> getResultDB(String idTeam) throws Exception {
        MutableLiveData<List<Result>> result = new MutableLiveData<>();
        result.setValue(resultMock());
        throw new Exception("La lista no puede estar null");
    }

    @Override
    public MutableLiveData<ResultResponse> getResultInternet(String idTeam) throws Exception {
        MutableLiveData<ResultResponse> resultResponse = new MutableLiveData<>();
        resultResponse.setValue(null);
        //Todo how Mock Rest?
        throw new Exception("La lista no puede estar null");
    }

    @Override
    public List<Result> saveResultDB(List<Result> resultList) throws Exception {
        if (resultList == null) {
            throw new Exception("La lista no puede estar null");
        } else if (resultList.isEmpty()) {
            throw new Exception("La lista no puede estar vacia");
        }
        return resultList;
    }


    public static List<Result> resultMock() {
        return ResultTestBuilder.getResultList();
    }

    public static List<Team> teamMock() {
        return TeamTestBuilder.getTeamList();
    }

}
