package cl.ugm;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

import java.util.StringTokenizer;

public class MyReducer extends Reducer <Text, DoubleWritable, Text, DoubleWritable> {
	
	public MyReducer(){}

	@Override
	protected void reduce (Text estacion, Iterable<DoubleWritable> valores, Context contexto) 
	throws IOException, InterruptedException {

		DoubleWritable min = new DoubleWritable(Double.MAX_VALUE);
		for (DoubleWritable valor: valores){
			System.out.println(estacion + " " + valor);
			if(valor.get()<min.get()){
				min.set(valor.get());
			}
		}		
		contexto.write(estacion,min);
	}

}