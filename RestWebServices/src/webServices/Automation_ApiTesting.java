package webServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class Automation_ApiTesting {
	
	
	@Test(enabled = false)
	public void getmethod() throws IOException
	{
		URL url=new URL("http://localhost:3000/employees");
		HttpURLConnection connection= (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responsecode= connection.getResponseCode();
		String responsemessage= connection.getResponseMessage();
		
		System.out.println("The response code is :" + responsecode);
		System.out.println("The response message is :" + responsemessage);
		
		
		InputStream inputstream= connection.getInputStream();
		InputStreamReader inStreamReader=new InputStreamReader(inputstream);
		BufferedReader reader=new BufferedReader(inStreamReader);
		
		String line;
		StringBuffer buffer=new StringBuffer();
		
		
		while((line=reader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	}
	
	@Test(enabled=false)
	public void postmethod() throws IOException
	{
		
		URL url=new URL("http://localhost:3000/employees");
		HttpURLConnection connection= (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		
		connection.setRequestProperty("Content-Type", "application/java");
		connection.setDoOutput(true);
		
		
		String body="\"first_name\": \"Elakya\",    \"last_name\": \"Dayalan\"";
		byte[] bytebody= body.getBytes();
		
		OutputStream outputstream= connection.getOutputStream();
		outputstream.write(bytebody);
		
		System.out.println(outputstream);
		
		InputStream inputstream= connection.getInputStream();
		InputStreamReader inputstrReader=new InputStreamReader(inputstream);
		BufferedReader buffReader=new BufferedReader(inputstrReader);
		
		StringBuffer buffer=new StringBuffer();
		String line;
		while((line=buffReader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
		
	}
	
	
	@Test(enabled=false)
	public void putmethod() throws IOException
	{
		URL url=new URL("http://localhost:3000/employees/3");
		HttpURLConnection connection= (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		
		connection.setRequestProperty("Content-Type", "application/java");
		connection.setDoOutput(true);
		
		String body="\"first_name\": \"ElakyaAnand\",    \"last_name\": \"Dayalan\"";
		byte[] bytebody= body.getBytes();
		
		OutputStream outputstream= connection.getOutputStream();
		outputstream.write(bytebody);
		
		System.out.println(outputstream);
		
		InputStream  inputstream= connection.getInputStream();
		InputStreamReader inputreader=new InputStreamReader(inputstream);
		BufferedReader reader=new BufferedReader(inputreader);
		
		StringBuffer buffer=new StringBuffer();
		String line;
		
		while((line=reader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	}
	
	@Test
	public void deletemethod() throws IOException
	{
		URL url=new URL("http://localhost:3000/employees/3");
		HttpURLConnection connection= (HttpURLConnection) url.openConnection();
		
		connection.setRequestMethod("DELETE");
		connection.setDoOutput(true);
		
		InputStream inputStream= connection.getInputStream();
		InputStreamReader inputreader=new InputStreamReader(inputStream);
		BufferedReader buffereader=new BufferedReader(inputreader);
		
		String line;
		StringBuffer buffer=new StringBuffer();
		
		while((line=buffereader.readLine())!=null)
		{
			buffer.append(line);
		}
		System.out.println(buffer);
	}
	

}
