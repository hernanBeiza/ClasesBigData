package cl.ugm;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.StringTokenizer;

public class MyMapper extends Mapper <Object, Text, Text, IntWritable> {
	
	public MyMapper(){ }

	public void map(Object k, Text linea, Context contexto){
		System.out.println("MyMapper");
		System.out.println("Key: "+k+" Valor: "+linea);

		StringTokenizer parser = new StringTokenizer(linea.toString(),";");
		try {
			while(parser.hasMoreTokens()){
				Integer idDocumento = Integer.parseInt(parser.nextToken());
				Text titulo = new Text(parser.nextToken());
				Text texto = new Text(parser.nextToken());
				//System.out.println(texto.toString());
				StringTokenizer parser2 = new StringTokenizer(texto.toString()," ");
				try {
					while (parser2.hasMoreTokens()) {
						Text palabra = new Text(parser2.nextToken());
						System.out.println(palabra);
						contexto.write(palabra,new IntWritable(idDocumento));
					}
				}
				catch(Exception ex){
					//ex.printStackTrace();
				}
			}
		}
		catch(Exception ex){
			//ex.printStackTrace();
		}

			
	}
	
}