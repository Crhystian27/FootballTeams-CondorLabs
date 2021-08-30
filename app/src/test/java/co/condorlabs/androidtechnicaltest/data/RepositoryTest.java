package co.condorlabs.androidtechnicaltest.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import co.condorlabs.androidtechnicaltest.RepositoryTestMock;
import co.condorlabs.androidtechnicaltest.ResultTestBuilder;
import co.condorlabs.androidtechnicaltest.TeamTestBuilder;
import co.condorlabs.androidtechnicaltest.data.entity.Result;
import co.condorlabs.androidtechnicaltest.data.entity.Team;

public class RepositoryTest {

    private RepositoryTestMock mock;


    @Before
    public void setup() {
        mock = new RepositoryTestMock();
    }


    @Test
    public void getTeamDB() {

        //Arrange
        List<Team> response;
        List<Team> data = RepositoryTestMock.teamMock();

        try {
            //Act
            response = mock.getTeamDB("idLeague").getValue();

            //Assert
            assertEquals(data, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getResultDB() {

        //Arrange
        List<Result> response;
        List<Result> data = RepositoryTestMock.resultMock();

        try {
            //Act
            response = mock.getResultDB("idTeam").getValue();

            //Assert
            assertEquals(data, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTeamDB() throws Exception {

        //Arrange
        List<Team> team = new ArrayList<>();
        team.add(new TeamTestBuilder().build());
        team.add(new TeamTestBuilder().build());
        team.add(new TeamTestBuilder().build());

        //Act
        List<Team> teamResponse = mock.saveTeamDB(team);
        System.out.println(teamResponse);

        //Assert
        assertEquals(team, teamResponse);

    }

    @Test
    public void insertResultDB() throws Exception {

        //Arrange
        List<Result> result = new ArrayList<>();
        result.add(new ResultTestBuilder().build());
        result.add(new ResultTestBuilder().build());
        result.add(new ResultTestBuilder().build());

        //Act
        List<Result> resultResponse = mock.saveResultDB(result);
        System.out.println(resultResponse);

        //Assert
        assertEquals(result, resultResponse);

    }
}
