package com.numble.carrotmarket.repository.memo;

import com.numble.carrotmarket.entity.memo.Memo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
    List<Memo> findByMnoBetween(Long from, Long to, Pageable pageable);
}
