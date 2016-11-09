package practica8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import practica8.Archivo;

import java.lang.reflect.*;

public class Saver {
	
	public <T> void save(T o) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Class<? extends Object> clase = o.getClass();
		if (clase.isAnnotationPresent(Archivo.class)){
			Map<String,Object> atributos = new HashMap<String,Object>();
			for(Field f : clase.getDeclaredFields()){
				if (f.isAnnotationPresent(AlmacenarAtributo.class)){
					Method metod;
					metod = clase.getMethod("get"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1), null);
					atributos.put(f.getName(), metod.invoke(o, null));
					
				}
			}
			String ruta =  clase.getAnnotation(Archivo.class).nombre();
			File archivo = new File(ruta);
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
			bw.write("<nombreClase>" + clase.getName() +"</nombreClase>");
			for (String key : atributos.keySet()) {
				bw.newLine();
				bw.write("<nombreAtributo>" + key +"</nombreAtributo>");
				bw.newLine();
				bw.write("<nombreValor>" + atributos.get(key) +"</nombreValor>");
			}
			bw.newLine();
			bw.close();
		} else {
			System.out.println("La clase no esta anotada con 'Archivo'");
		}
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
		// NO ATRAPO UNA MIERDA
		Mapeador map = new Mapeador();
		new Saver().save(map);
		
	}
		
		
}
