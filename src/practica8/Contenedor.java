package practica8;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Contenedor {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// INFO DEL SERVIDOR
		final Class<?> servidor = Class.forName("practica8.MiPrimerServidorEnJava");
		String direccion = servidor.getAnnotation(Servidor.class).direccion();
		int puerto = servidor.getAnnotation(Servidor.class).puerto();
		String archivo = servidor.getAnnotation(Servidor.class).archivo();
		// ARMAR LA CONEXION
		HttpServer server = HttpServer.create(new InetSocketAddress(puerto), 0);
		server.createContext(direccion, new HttpHandler() {
			// RECIBIS EL PEDIDO
			@Override
			public void handle(HttpExchange arg0) throws IOException {
				String ip = arg0.getRemoteAddress().getHostName();
				String fecha = new Date().toString();
				String log = "FECHA Y HORA: " + fecha +" ,IP CLIENTE: "+ip;
				System.out.println(log);
				for(Method f : servidor.getMethods()){
					if(f.isAnnotationPresent(Invocar.class)){
						try {
							f.invoke(null);
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
            String response = "<html><head><title>HOLA MUNDO</title></head><body><h1>Esta es tu respuesta</h1></body></html>";
            arg0.sendResponseHeaders(200, response.length());
  			OutputStream os = arg0.getResponseBody();
  			os.write(response.getBytes());
         	os.close();
				
			}
		});
		server.setExecutor(null);
		server.start();
		
	}

}
