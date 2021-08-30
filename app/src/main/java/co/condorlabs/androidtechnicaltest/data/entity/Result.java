package co.condorlabs.androidtechnicaltest.data.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Entity(tableName = "result_table", indices = {@Index(value = "id", unique = true)})
public final class Result {

    @PrimaryKey
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
}
