package co.condorlabs.androidtechnicaltest.data;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import co.condorlabs.androidtechnicaltest.data.dao.ResultDao;
import co.condorlabs.androidtechnicaltest.data.dao.TeamDao;
import co.condorlabs.androidtechnicaltest.data.dto.ResultResponse;
import co.condorlabs.androidtechnicaltest.data.dto.TeamResponse;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;
import co.condorlabs.androidtechnicaltest.rest.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class Repository implements RepositoryInterface {


    private final ApiService apiService;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final Executor executor;
    private final TeamDao teamDao;
    private final ResultDao resultDao;

    @Inject
    public Repository(ApiService apiService, Executor executor, TeamDao teamDao, ResultDao resultDao) {
        this.apiService = apiService;
        this.executor = executor;
        this.teamDao = teamDao;
        this.resultDao = resultDao;
    }

    @Override
    public MutableLiveData<ResultResponse> getResultInternet(String idTeam) {
        MutableLiveData<ResultResponse> response = new MutableLiveData<>();
        executor.execute(() -> compositeDisposable.add(apiService.getResults(idTeam)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response::setValue, throwable -> {
                            response.setValue(null);
                            Log.e(throwable.toString(), throwable.getMessage());
                        }
                )));
        return response;
    }

    @Override
    public MutableLiveData<TeamResponse> getTeamInternet(String idLeague) {
        MutableLiveData<TeamResponse> response = new MutableLiveData<>();
        executor.execute(() -> compositeDisposable.add(apiService.getTeams(idLeague)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response::setValue, throwable -> {
                            response.setValue(null);
                            Log.e(throwable.toString(), throwable.getMessage());
                        }
                )));

        return response;
    }


    @Override
    public List<Team> saveTeamDB(List<Team> teamList) throws Exception {
        if (teamList == null || teamList.isEmpty()) {
            throw new Exception();
        } else {
            executor.execute(() -> {
                for (Team team : teamList) {
                    if (!teamDao.compareTo(team.getIdTeam())) {
                        teamDao.insertAllTeam(teamList);
                    }
                }
            });

        }
        return teamList;
    }

    @Override
    public List<Result> saveResultDB(List<Result> resultList) throws Exception {
        if (resultList == null || resultList.isEmpty()) {
            throw new Exception();
        } else {
            executor.execute(() -> {
                for (Result result : resultList) {
                    if (!resultDao.compareTo(result.getIdEvent())) {
                        resultDao.insertAllResult(resultList);
                    }
                }
            });
        }
        return resultList;
    }

    @Override
    public MutableLiveData<List<Team>> getTeamDB(String idLeague) {
        MutableLiveData<List<Team>> response = new MutableLiveData<>();
        response.setValue(teamDao.getIdLeague(idLeague));
        return response;
    }

    @Override
    public MutableLiveData<List<Result>> getResultDB(String idTeam) {
        MutableLiveData<List<Result>> response = new MutableLiveData<>();
        response.setValue(resultDao.getIdResult(idTeam));
        return response;
    }

}
