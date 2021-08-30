package co.condorlabs.androidtechnicaltest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.condorlabs.androidtechnicaltest.data.entity.Result;

public class ResultTestBuilder {

    public Integer id;
    public String idEvent;
    public String idSoccerXML;
    public String idAPIfootball;
    public String strEvent;
    public String strEventAlternate;
    public String strFilename;
    public String strSport;
    public String idLeague;
    public String strLeague;
    public String strSeason;
    public String strDescriptionEN;
    public String strHomeTeam;
    public String strAwayTeam;
    public String intHomeScore;
    public String intRound;
    public String intAwayScore;
    public String intSpectators;
    public String strOfficial;
    public String strHomeGoalDetails;
    public String strHomeRedCards;
    public String strHomeYellowCards;
    public String strHomeLineupGoalkeeper;
    public String strHomeLineupDefense;
    public String strHomeLineupMidfield;
    public String strHomeLineupForward;
    public String strHomeLineupSubstitutes;
    public String strHomeFormation;
    public String strAwayRedCards;
    public String strAwayYellowCards;
    public String strAwayGoalDetails;
    public String strAwayLineupGoalkeeper;
    public String strAwayLineupDefense;
    public String strAwayLineupMidfield;
    public String strAwayLineupForward;
    public String strAwayLineupSubstitutes;
    public String strAwayFormation;
    public String intHomeShots;
    public String intAwayShots;
    public Date strTimestamp;
    public String dateEvent;
    public String dateEventLocal;
    public String strTime;
    public String strTimeLocal;
    public String strTVStation;
    public String idHomeTeam;
    public String idAwayTeam;
    public String strResult;
    public String strVenue;
    public String strCountry;
    public String strCity;
    public String strPoster;
    public String strSquare;
    public String strFanart;
    public String strThumb;
    public String strBanner;
    public String strMap;
    public String strTweet1;
    public String strTweet2;
    public String strTweet3;
    public String strVideo;
    public String strStatus;
    public String strPostponed;
    public String strLocked;
    public static List<Result> list;

    public ResultTestBuilder() {
        this.id = 1234;
        this.idEvent = "idEvent";
        this.idSoccerXML = "idSoccerXML";
        this.idAPIfootball = "idAPIfootball";
        this.strEvent = "strEvent";
        this.strEventAlternate = "strEventAlternate";
        this.strFilename = "strFilename";
        this.strSport = "strSport";
        this.idLeague = "idLeague";
        this.strLeague = "strLeague";
        this.strSeason = "strSeason";
        this.strDescriptionEN = "strDescriptionEN";
        this.strHomeTeam = "strHomeTeam";
        this.strAwayTeam = "strAwayTeam";
        this.intHomeScore = "intHomeScore";
        this.intRound = "intRound";
        this.intAwayScore = "intAwayScore";
        this.intSpectators = "intSpectators";
        this.strOfficial = "strOfficial";
        this.strHomeGoalDetails = "strHomeGoalDetails";
        this.strHomeRedCards = "strHomeRedCards";
        this.strHomeYellowCards = "strHomeYellowCards";
        this.strHomeLineupGoalkeeper = "strHomeLineupGoalkeeper";
        this.strHomeLineupDefense = "strHomeLineupDefense";
        this.strHomeLineupMidfield = "strHomeLineupMidfield";
        this.strHomeLineupForward = "strHomeLineupForward";
        this.strHomeLineupSubstitutes = "strHomeLineupSubstitutes";
        this.strHomeFormation = "strHomeFormation";
        this.strAwayRedCards = "strAwayRedCards";
        this.strAwayYellowCards = "strAwayYellowCards";
        this.strAwayGoalDetails = "strAwayGoalDetails";
        this.strAwayLineupGoalkeeper = "strAwayLineupGoalkeeper";
        this.strAwayLineupDefense = "strAwayLineupDefense";
        this.strAwayLineupMidfield = "strAwayLineupMidfield";
        this.strAwayLineupForward = "strAwayLineupForward";
        this.strAwayLineupSubstitutes = "strAwayLineupSubstitutes";
        this.strAwayFormation = "strAwayFormation";
        this.intHomeShots = "intHomeShots";
        this.intAwayShots = "intAwayShots";
        this.strTimestamp = null;
        this.dateEvent = "dateEvent";
        this.dateEventLocal = "dateEventLocal";
        this.strTime = "strTime";
        this.strTimeLocal = "strTimeLocal";
        this.strTVStation = "strTVStation";
        this.idHomeTeam = "idHomeTeam";
        this.idAwayTeam = "idAwayTeam";
        this.strResult = "strResult";
        this.strVenue = "strVenue";
        this.strCountry = "strCountry";
        this.strCity = "strCity";
        this.strPoster = "strPoster";
        this.strSquare = "strSquare";
        this.strFanart = "strFanart";
        this.strThumb = "strThumb";
        this.strBanner = "strBanner";
        this.strMap = "strMap";
        this.strTweet1 = "strTweet1";
        this.strTweet2 = "strTweet2";
        this.strTweet3 = "strTweet3";
        this.strVideo = "strVideo";
        this.strStatus = "strStatus";
        this.strPostponed = "strPostponed";
        this.strLocked = "strLocked";
    }

    public Result build() {
        return new Result(id, idEvent, idSoccerXML, idAPIfootball, strEvent, strEventAlternate, strFilename, strSport, idLeague, strLeague, strSeason, strDescriptionEN, strHomeTeam, strAwayTeam, intHomeScore, intRound, intAwayScore, intSpectators, strOfficial, strHomeGoalDetails, strHomeRedCards, strHomeYellowCards, strHomeLineupGoalkeeper, strHomeLineupDefense, strHomeLineupMidfield, strHomeLineupForward, strHomeLineupSubstitutes, strHomeFormation, strAwayRedCards, strAwayYellowCards, strAwayGoalDetails, strAwayLineupGoalkeeper, strAwayLineupDefense, strAwayLineupMidfield, strAwayLineupForward, strAwayLineupSubstitutes, strAwayFormation, intHomeShots, intAwayShots, strTimestamp, dateEvent, dateEventLocal, strTime, strTimeLocal, strTVStation, idHomeTeam, idAwayTeam, strResult, strVenue, strCountry, strCity, strPoster, strSquare, strFanart, strThumb, strBanner, strMap, strTweet1, strTweet2, strTweet3, strVideo, strStatus, strPostponed, strLocked);
    }

    public static List<Result> getResultList() {
        list = new ArrayList<>();
        list.add(new ResultTestBuilder().build());
        list.add(new ResultTestBuilder().build());
        list.add(new ResultTestBuilder().build());
        return list;
    }
}
