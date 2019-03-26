package com.project.picktoon.repository.custom;

import com.project.picktoon.domain.*;
import com.project.picktoon.dto.SearchKeyword;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class WebtoonRepositoryImpl extends QuerydslRepositorySupport implements WebtoonRepositoryCustom {

    public WebtoonRepositoryImpl(){ super(Webtoon.class);}

    @Override
    public List<Webtoon> getWebtoons(List<SearchKeyword> keywords, String searchStr) {
        QWebtoon webtoon = QWebtoon.webtoon;
        QKeyword keyword = QKeyword.keyword;

        JPQLQuery<Webtoon>jpqlQuery = from(webtoon).innerJoin(webtoon.platform).fetchJoin()
<<<<<<< HEAD
                .innerJoin(webtoon.keywords, keyword).fetchJoin()
                .distinct();
=======
                                        .innerJoin(webtoon.keywords, keyword).fetchJoin()
                                        .distinct();
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5

        BooleanBuilder builder = new BooleanBuilder();

        if(keywords != null){
            for(SearchKeyword k : keywords){
<<<<<<< HEAD
                builder.or(keyword.keywordType.eq(k.getKeyWordType()).and(keyword.keywordValue.eq(k.getKeyWordValue())));
=======
                builder.or(keyword.keywordType.eq(k.getKeywordType()).and(keyword.keywordValue.eq(k.getKeywordValue())));
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5
            }
            jpqlQuery.where(builder);

        }

        if(searchStr != null){
            jpqlQuery.where(webtoon.title.like("%"+ searchStr + "%"));
        }

        jpqlQuery.orderBy(webtoon.id.asc());


        return jpqlQuery.fetch();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1536989a83e316143dc1b17b62f943ad481ee5c5
