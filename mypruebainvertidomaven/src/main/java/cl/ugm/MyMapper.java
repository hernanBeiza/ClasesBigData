package cl.ugm;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.util.StringTokenizer;

// Si necesito expulsar otro tipo de dato debo editar acá
public class MyMapper extends Mapper <Object, Text, Text, Text> {
	
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
						// Lo paso a mayúsculas para agrupar bien por el texto y no diferenciar con las minus
						Text palabra = new Text(parser2.nextToken().toUpperCase());
						System.out.println(palabra);
						contexto.write(palabra,new Text(String.valueOf(idDocumento)));
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