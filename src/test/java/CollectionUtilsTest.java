import org.example.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionUtilsTest {

    @Test
    @DisplayName("List<Integer>를 정렬하고 중복을 제거하는 함수를 만든다")
    void testRemoveDuplicatesAndSort(){
        //문제
        List<Integer> input = Arrays.asList(5, 3, 5, 1);
        //원하는 답
        List<Integer> expected = Arrays.asList(1, 3, 5);

        List<Integer> result = CollectionUtils.removeDuplicatesAndSort(input);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("비어있는 리스트를 주었을떄")
    void testEmptyList(){
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();

        assertEquals(expected, CollectionUtils.removeDuplicatesAndSort(input));
    }
    @Test
    @DisplayName("배열을 리스트로 변환")
    void testSingleElement(){
        List<Integer> input = Arrays.asList(42);
        List<Integer> expected = Arrays.asList(42);

        assertEquals(expected, CollectionUtils.removeDuplicatesAndSort(input));
    }

    @Test
    void addTest(){
        List<Integer> input = new ArrayList<>();
        //인덱스 끝에 추가
        input.add(1);
        input.add(3);
        input.add(5);
        //인덱스를 지정해서 추가
        input.add(1,2);
        //인덱스에 저장된 객체를 주어진 객체로 변환
        input.set(3,4);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4);

        assertEquals(expected, input);
    }

    @Test
    void searchBooleanTest(){
        List<Integer> input = Arrays.asList(1,2,3,4);
        //주어진 객체가 저장되어 있는지 여부
        boolean contains = input.contains(2);
        assertEquals(true, contains);
    }
    @Test
    void searchGetTest(){
        List<Integer> input = Arrays.asList(1,2,3,4);
        //주어진 인덱스에 저장된 객체를 리턴
        int getInteger = input.get(1);
        assertEquals(2, getInteger);
    }
    @Test
    void searchIsEmptyTest(){
        List<Integer> input = Arrays.asList(1,2,3,4);
        //컬렉션이 비어있는지 조사
        boolean isEmpty = input.isEmpty();
        assertEquals(false, isEmpty);
    }
    @Test
    void searchSizeTest(){
        List<Integer> input = Arrays.asList(1,2,3,4);
        //저장되어 있는 전체 객체수를 리턴
        int size = input.size();
        assertEquals(4, size);
    }
    @Test
    void removeClearTest(){
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        //저장된 있는 모든 객체를 삭제
        input.clear();

        assertEquals(true, input.isEmpty());
    }
    @Test
    void removeRemoveTest(){
        List<Integer> input = CollectionUtils.arraysMake(1,2,3);
        List<Integer> expected = Arrays.asList(1);
        //주어진 인덱스에 저장된 객체를
        input.remove(1);
        //주어진 리스트트에서 첫 번째로 일치하는 객체를 삭제
        input.remove(Integer.valueOf(3));
        assertEquals(expected, input);
    }
    @Test
    void removeObjectAll() {
        List<Integer> input = CollectionUtils.arraysMake(1,2,3,3,3);
        List<Integer> expected = Arrays.asList(1,2);
        //지정된 값과 해당하는 모든 값을 제거하는 반복문
        input.removeIf(n -> n.equals(3));
        assertEquals(expected, input);
    }
}
