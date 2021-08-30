package co.condorlabs.androidtechnicaltest.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import co.condorlabs.androidtechnicaltest.data.Repository;
import co.condorlabs.androidtechnicaltest.data.dto.ResultResponse;
import co.condorlabs.androidtechnicaltest.data.dto.TeamResponse;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public class MainViewModel extends ViewModel {

    private final Repository repository;
    private MutableLiveData<TeamResponse> team;
    private MutableLiveData<ResultResponse> result;
    private MutableLiveData<List<Team>> teamList;
    private MutableLiveData<List<Result>> resultList;

    @Inject
    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<TeamResponse> getTeamInternet(String idLeague) {
        team = new MutableLiveData<>();
        team = repository.getTeamInternet(idLeague);
        return team;
    }

    public LiveData<ResultResponse> getResultInternet(String idTeam) {
        result = new MutableLiveData<>();
        result = repository.getResultInternet(idTeam);
        return result;
    }


    public boolean saveTeamDB(List<Team> team) throws Exception {
        if (team != null) {
            repository.saveTeamDB(team);
            return true;
        } else {
            throw new Exception();
        }
    }

    public boolean saveResultDB(List<Result> result) throws Exception {
        if (result != null) {
            repository.saveResultDB(result);
            return true;
        } else {
            throw new Exception();
        }
    }

    public LiveData<List<Team>> getTeamDB(String idLeague) {
        teamList = new MutableLiveData<>();
        teamList = repository.getTeamDB(idLeague);
        return teamList;
    }

    public LiveData<List<Result>> getResultDB(String idTeam) {
        resultList = new MutableLiveData<>();
        resultList = repository.getResultDB(idTeam);
        return resultList;
    }


}