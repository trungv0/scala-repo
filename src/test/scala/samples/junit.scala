package samples

import org.junit._
import Assert._

import org.apache.spark.sql.SparkSession

@Test
class AppTest {

    @Test
    def testOK() = assertTrue(true)

    @Test
    def checkSparkSetup(): Unit = {

        // Create spark session
        val spark = SparkSession.builder().master("local").getOrCreate()
        import spark.implicits._

        val data = Seq(("1"), ("2")).toDF("c1")

        data.show()
        data.write.format("parquet").mode("overwrite").save("/tmp/data1")
    }

}


