package com.agilestar.hellospark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
    def main(args:Array[String]){
    
    val inputFile = "hdfs://192.168.91.128:9880/user/spark/word/word.txt"
    val conf = new SparkConf().setAppName("WorkCount")
    val sc = new SparkContext(conf)
    val textFile = sc.textFile(inputFile)
    textFile.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect().foreach(println)

    sc.stop();
  }
}