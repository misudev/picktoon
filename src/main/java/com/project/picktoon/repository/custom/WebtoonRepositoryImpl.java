package com.project.picktoon.repository.custom;

import com.project.picktoon.domain.*;
import com.project.picktoon.dto.SearchKeyword;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class WebtoonRepositoryImpl extends QuerydslRepositorySupport implements WebtoonRepositoryCustom {

    public WebtoonRepositoryImpl() {
        super(Webtoon.class);
    }

    @Override
    public List<Webtoon> getWebtoons(List<SearchKeyword> keywords, String searchStr) {
        QWebtoon webtoon = QWebtoon.webtoon;
        QKeyword keyword = QKeyword.keyword;

        //  select w.id wid, count(*) c from webtoon w, webtoon_keyword wk, keyword k where
        //				(wk.keyword_id = k.id and w.id = wk.webtoon_id )
        //               and (
        //						(keyword_value = '월' and keyword_type = '1' )
        //						or (  keyword_value = '코믹' and keyword_type = '2' )
        //               )
        //               group by w.id
        //               having c = 2

        JPQLQuery<Webtoon> jpqlQuery = from(webtoon).innerJoin(webtoon.platform)
                .innerJoin(webtoon.keywords, keyword);

        BooleanBuilder builder = new BooleanBuilder();
        if (keywords != null) {
            for (SearchKeyword k : keywords) {
                builder.or(keyword.keywordType.eq(k.getKeywordType()).and(keyword.keywordValue.eq(k.getKeywordValue())));
            }
            jpqlQuery.where(builder);
        }


        if (searchStr != null) {
            jpqlQuery.where(webtoon.title.like("%" + searchStr + "%"));
        }

        jpqlQuery.groupBy(webtoon.id);
        jpqlQuery.having(webtoon.count().eq((long)keywords.size()));

        List<Tuple> tuples = jpqlQuery.select(webtoon.id, webtoon.count()).fetch();
        // select * from webtoon where id in (2,15, 16) order by id;

        JPQLQuery<Webtoon> jpqlQuery2 = from(webtoon).innerJoin(webtoon.platform)
                .innerJoin(webtoon.keywords, keyword).distinct();

        jpqlQuery2.where(webtoon.id.in(tuplesToIds(tuples)));
        return jpqlQuery2.fetch();
    }

    public List<Long> tuplesToIds(List<Tuple> tuples){
        List<Long> webtoonIds = new ArrayList<>();
        for(Tuple t : tuples)
            webtoonIds.add(t.get(0, Long.class));
        return webtoonIds;

    }


}
