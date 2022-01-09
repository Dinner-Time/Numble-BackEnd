package com.numble.carrotmarket.memo;

import com.numble.carrotmarket.entity.memo.Memo;
import com.numble.carrotmarket.repository.memo.MemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void test() {
        System.out.println(memoRepository.getClass().getName());
    }

    // insert test
    @Test
    public void testInsert() {

        // 1부터 100까지 for문을 실행
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memoRepository.save(memo); // insert or update
        });
    }

    // select one test
    @Test
    public void testSelectFindById() {
        Long mno = 100L; // pk

        // findById는 Optional타입으로 반환
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("=====================================");

        // 값이 존재하는지 체크
        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    // update test
    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Updated").build();

        System.out.println(memoRepository.save(memo));
    }

    // delete test
    @Test
    public void testDelete(){
        Long mno = 100L;

        memoRepository.deleteAll();
    }

    // paging test
    @Test
    public void testPaging(){
        Pageable pageable = PageRequest.of(0,10);

        Page<Memo> result = memoRepository.findAll(pageable);

        System.out.println(result);
        System.out.println("===============================");
        System.out.println("Total Page: " +result.getTotalPages());
        System.out.println("===============================");
        System.out.println("Total Count: " +result.getTotalElements());
        System.out.println("===============================");
        System.out.println("Page Number: " +result.getNumber());
        System.out.println("===============================");
        System.out.println("Page Size: " +result.getSize());
        System.out.println("===============================");
        System.out.println("Has next page?: " +result.hasNext());
        System.out.println("===============================");
        System.out.println("Is first page?: " +result.isFirst());

        System.out.println("===============================");

        for (Memo memo: result.getContent()) {
            System.out.println(memo);
        }
    }

    // sort test
    @Test
    public void testSort(){
        Sort sortDesc = Sort.by("mno").descending();
        Sort sortByMemoText = Sort.by("memoText").ascending();
        Sort sort = sortDesc.and(sortByMemoText);

        Pageable pageable = PageRequest.of(0,10, sort);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });
    }

    // query method test
    @Test
    public void testQueryMethod(){
        List<Memo> result = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 90L);

        for(Memo memo: result){
            System.out.println(memo);
        }
    }
    @Test
    public void testQueryMethodWithPagable(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());

        List<Memo> result = memoRepository.findByMnoBetween(70L, 100L, pageable);

        for(Memo memo: result){
            System.out.println(memo);
        }
    }
}
