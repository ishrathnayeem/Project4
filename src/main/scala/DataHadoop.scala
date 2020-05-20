import java.io.FileNotFoundException
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path}

  trait DataHadoop extends App {

    val conf = new Configuration()

    conf.addResource(new Path("/Users/ishrathnayeem/Hadoop/opt/hadoop/etc/cloudera/core-site.xml"))
    conf.addResource(new Path("/Users/ishrathnayeem/Hadoop/opt/hadoop/etc/cloudera/hdfs-site.xml"))
    val hadoop = FileSystem.get(conf)

    val stagingarea = new Path("/user/fall2019/ishrath/project4")

    val trips = new Path("/user/fall2019/ishrath/project4/trips")
    val calendar_dates = new Path("/user/fall2019/ishrath/project4/calendar_dates")
    val  frequencies = new Path("/user/fall2019/ishrath/project4/frequencies")

    val trips_txt = new Path("/Users/ishrathnayeem/IntelliJ IDEA/mcit/gtfs_stm/trips.txt")
    val calendar_dates_txt = new Path("/Users/ishrathnayeem/IntelliJ IDEA/mcit/gtfs_stm/calendar_dates.txt")
    val frequencies_txt = new Path("/Users/ishrathnayeem/IntelliJ IDEA/mcit/gtfs_stm/frequencies.txt")

    if (hadoop.exists(stagingarea))
      try {
        hadoop.delete(stagingarea, true)
        hadoop.mkdirs(stagingarea)
        hadoop.listStatus(stagingarea)
        println("PROJECT4 Directory was CREATED\n")
      }
      catch {
        case f: FileNotFoundException =>
          println("PROJECT4 PATH CANNOT FIND\n")
      }

    hadoop.mkdirs(trips)
    println("created directory for trips\n")

    hadoop.mkdirs(calendar_dates)
    println("created directory for calendar_dates\n")

    hadoop.mkdirs(frequencies)
    println("created directory for frequencies\n")
}
