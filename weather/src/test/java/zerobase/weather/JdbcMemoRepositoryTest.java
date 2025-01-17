package zerobase.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import zerobase.weather.repository.JdbcMemoRepository;
import zerobase.weather.domain.Memo;


@SpringBootTest
@Transactional
class JdbcMemoRepositoryTest {
    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
    	//given
        Memo newMemo = new Memo(2, "insert memo test");
        
        //when
        jdbcMemoRepository.save(newMemo);
        
        //then
        Optional<Memo> result = jdbcMemoRepository.findById(2);
        assertEquals(result.get().getText() , "insert memo test");
    }
    
    @Test
    void findAllMemoTtest() {
    	List<Memo> memoList = jdbcMemoRepository.findAll();
    	System.out.println(memoList);
    	assertNotNull(memoList);
    }
}