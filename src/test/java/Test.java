import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {

//    @org.junit.Test
    public void testOptional(){
        Optional<String> optional = Optional.of("A");
        Assert.assertEquals("A", optional.get());
    }

    @org.junit.Test
    public void testArray(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        boolean anyMatch = list.stream().anyMatch(Predicate.isEqual(1));
        System.out.println(anyMatch);

        boolean match = list.stream().allMatch(Predicate.isEqual(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println(match);


    }
}
