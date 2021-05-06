import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test {

    @org.junit.Test
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

    @org.junit.Test
    public void removeDuplicates() {
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;

        int j = nums[0];
        int[] re = new int[nums.length];
        re[0] = j;
        int k = 1;

        for(int i=1,len=nums.length; i<len; i++){
            if(nums[i] == j){
                continue;
            }

            re[k] = nums[i];
            k++;
            j = nums[i];
        }

        nums = new int[k];
        for(int i=0; i<k; i++){
            nums[i] = re[i];
            System.out.println(nums[i]);
        }
    }

    @org.junit.Test
    public void testHashMapSize(){
        Map map = new HashMap(16);
        System.out.println(map.size());
    }

}
