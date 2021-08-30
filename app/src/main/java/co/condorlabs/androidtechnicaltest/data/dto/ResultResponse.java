package co.condorlabs.androidtechnicaltest.data.dto;


import java.util.List;

import co.condorlabs.androidtechnicaltest.data.entity.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class ResultResponse {

    List<Result> results;
}
