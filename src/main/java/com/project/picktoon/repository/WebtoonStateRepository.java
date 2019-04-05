
package com.project.picktoon.repository;

import com.project.picktoon.domain.WebtoonState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WebtoonStateRepository extends JpaRepository<WebtoonState, Long> {
    @Query(value = "SELECT * FROM webtoon_state  WHERE webtoon_id =:id", nativeQuery = true)
    public WebtoonState findWebtoonStateByWebtoonId(Long id);
}
