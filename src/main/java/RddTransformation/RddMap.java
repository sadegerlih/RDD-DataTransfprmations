
  //Veri setini sütünlara bölerek
 // istenilen sütun üzerinde işlem yapmaya olanak sağlar

package RddTransformation;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.VoidFunction;

public class RddMap extends Connection {
    public static void main(String[] args) {

        JavaRDD<CubModel> new_data = raw_data.map((Function<String, CubModel>) s -> {
            String[] split = s.split(",");
            return new CubModel(split[0], split[1], split[2], split[3], split[4],
                    split[5], Integer.parseInt(split[6]), split[7], split[8], split[9]);
        });
        new_data.foreach((VoidFunction<CubModel>) cubModel -> System.out.println(cubModel.getBirinci()));
    }
}
