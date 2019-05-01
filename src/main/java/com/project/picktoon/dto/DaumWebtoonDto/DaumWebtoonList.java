package com.project.picktoon.dto.DaumWebtoonDto;

import com.project.picktoon.dto.DaumWebtoonDto.DaumWebtoonInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DaumWebtoonList {

    List<DaumWebtoonInfo> data = new ArrayList<>();
}
