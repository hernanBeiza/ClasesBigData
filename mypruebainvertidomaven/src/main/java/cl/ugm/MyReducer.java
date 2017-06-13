package cl.ugm;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MyReducer extends Reducer <Text, IntWritable, Text, IntWritable> {

	public MyReducer(){
		System.out.println("MyReducer INIT");
	}

	@Override
	protected void reduce (Text palabra, Iterable<IntWritable> documentos, Context contexto)
	throws IOException, InterruptedException {

		System.out.println("MyReducer");
		System.out.println(palabra);

		for (IntWritable documento:documentos) {
			System.out.println(documento+" " +palabra);
			contexto.write(new Text(palabra.toString()),documento);
		}

	}

}