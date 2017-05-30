package cl.ugm;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.StringTokenizer;

public class MyMapper extends Mapper <Object, Text, Text, IntWritable> {
	
	public MyMapper(){ }

	public void map(Object k, Text linea, Context contexto){
		System.out.println("Procesando");
		System.out.println("Key: "+k);
		System.out.println("Valor: "+linea);
		StringTokenizer parser = new StringTokenizer(linea.toString()," ");
		while(parser.hasMoreTokens()){
			Text key = new Text(parser.nextToken());
			//Hay que saltarse los datos
			//nextToken es por parámetro delimitado, no línea			
			//Double valor = Double.parseDouble(parser.nextToken());
			//DubleWritable valueDouble = new DoubleWritable(valor);
			IntWritable value = new IntWritable(1);
			try {
				contexto.write(key,value);
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}	
	}
	
}