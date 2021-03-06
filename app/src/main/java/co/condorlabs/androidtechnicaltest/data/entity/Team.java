package co.condorlabs.androidtechnicaltest.data.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(tableName = "team_table", indices = {@Index(value = "id", unique = true)})
public final class Team {

    @PrimaryKey
    public Integer id;
    public String idTeam;
    public String idSoccerXML;
    public String idAPIfootball;
    public String intLoved;
    public String strTeam;
    public String strTeamShort;
    public String strAlternate;
    public String intFormedYear;
    public String strSport;
    public String strLeague;
    public String idLeague;
    public String strLeague2;
    public String idLeague2;
    public String strLeague3;
    public String idLeague3;
    public String strLeague4;
    public String idLeague4;
    public String strLeague5;
    public String idLeague5;
    public String strLeague6;
    public String idLeague6;
    public String strLeague7;
    public String idLeague7;
    public String strDivision;
    public String strManager;
    public String strStadium;
    public String strKeywords;
    public String strRSS;
    public String strStadiumThumb;
    public String strStadiumDescription;
    public String strStadiumLocation;
    public String intStadiumCapacity;
    public String strWebsite;
    public String strFacebook;
    public String strTwitter;
    public String strInstagram;
    public String strDescriptionEN;
    public String strDescriptionDE;
    public String strDescriptionFR;
    public String strDescriptionCN;
    public String strDescriptionIT;
    public String strDescriptionJP;
    public String strDescriptionRU;
    public String strDescriptionES;
    public String strDescriptionPT;
    public String strDescriptionSE;
    public String strDescriptionNL;
    public String strDescriptionHU;
    public String strDescriptionNO;
    public String strDescriptionIL;
    public String strDescriptionPL;
    public String strGender;
    public String strCountry;
    public String strTeamBadge;
    public String strTeamJersey;
    public String strTeamLogo;
    public String strTeamFanart1;
    public String strTeamFanart2;
    public String strTeamFanart3;
    public String strTeamFanart4;
    public String strTeamBanner;
    public String strYoutube;
    public String strLocked;

}
