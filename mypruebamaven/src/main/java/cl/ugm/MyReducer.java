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

public class MyReducer extends Reducer <Text, DoubleWritable, Text, DoubleWritable> {

	private ArrayList<Double> temperaturas;

	public MyReducer(){
		System.out.println("MyReducer INIT");
		temperaturas = new ArrayList<Double>();
	}

	@Override
	protected void reduce (Text estacion, Iterable<DoubleWritable> valores, Context contexto) 
	throws IOException, InterruptedException {

		System.out.println("MyReducer");
		//System.out.println(estacion);

		DoubleWritable max = new DoubleWritable(Double.MAX_VALUE);
		for (DoubleWritable valor: valores){
			//System.out.println(estacion + " " + valor);
			max.set(valor.get());
			temperaturas.add(valor.get());
		}

		Collections.sort(temperaturas);

		for (Double temp : temperaturas) {
			contexto.write(estacion,new DoubleWritable(temp));
		}

	}

}