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

		System.out.println("MyReducer.java: Valores para estación: "+estacion);

		for (DoubleWritable valor: valores) {
			System.out.println("MyReduder.java: " + estacion + " " + valor);
		}

		DoubleWritable max = new DoubleWritable(Double.MIN_VALUE);
		for (DoubleWritable valor: valores){
			//System.out.println(estacion + " " + valor);
			//total.set(total.get()+valor.get());
			if(valor.get()>max.get()){
				System.out.println("MyReducer.java: Nueva temperatura máxima encontrada para: "+estacion+" con: "+valor);
				max.set(valor.get());
			}
		}		
		contexto.write(estacion,max);
	}

}