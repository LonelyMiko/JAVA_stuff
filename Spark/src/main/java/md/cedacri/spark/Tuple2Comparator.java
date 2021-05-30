package md.cedacri.spark;

import scala.Tuple2;

import java.util.Comparator;

/**
 * This class sorts the data in Tuple2
 */
public class Tuple2Comparator implements Comparator<Tuple2<String,Integer>> {

    /**
     * This method takes two Tuple2 and sorts in ascending order
     * @param o1 first tuple
     * @param o2 second tuple
     * @return firstTuple - secondTuple
     */
    @Override
    public int compare(Tuple2<String, Integer> o1, Tuple2<String, Integer> o2) {
        return o2._2 - o1._2();
    }
}
