package md.cedacri.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class retrieves domains from a file and counts their number
 */
public class Domain {

    //Initializing Spark
    private static final SparkConf SPARK_CONF = new SparkConf().setAppName("Count Domains").setMaster("local");
    private static final JavaSparkContext SPARK_CONTEXT = new JavaSparkContext(SPARK_CONF);

    /**
     * This method reads a list of sites from a file and extracts their domain
     * @return a list of <code>Tuple2</code> which contains domains and their number
     */
    public List<Tuple2<String, Integer>> parseDomain()
    {

        JavaRDD<String> openFile = SPARK_CONTEXT.textFile("src/main/resources/list.txt",1);
        JavaRDD<String> domains = openFile.flatMap(line -> Collections.singletonList(
                line.substring(line.lastIndexOf(".") + 1)).iterator());

        JavaPairRDD<String, Integer> ones = domains.mapToPair(word -> new Tuple2<>(word, 1));
        JavaPairRDD<String, Integer> count = ones.reduceByKey(Integer::sum);

        return count.sortByKey().collect();
    }

    /**
     * This method returns the top 10 domains
     * @return a list of Tuple2 which contains top 10 domains by their number
     */
    public List<Tuple2<String, Integer>> topDomains()
    {
        List<Tuple2<String, Integer>> domains = parseDomain();

        List<Tuple2<String, Integer>> sortedDomains = new ArrayList<>(domains);
        sortedDomains.sort(new Tuple2Comparator());

        List<Tuple2<String, Integer>> topDomains = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            topDomains.add(sortedDomains.get(i));
        }

        return topDomains;
    }
}
