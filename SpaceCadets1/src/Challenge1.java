import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Challenge1 
{
	public static void main (String[] args)
	{
		BufferedReader email = new BufferedReader (new InputStreamReader (System.in));
		String adress=null;
		try 
		{
		adress=email.readLine();
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		
		
		String urlAdress = "http://www.ecs.soton.ac.uk/people/" + adress.substring(0,adress.indexOf("@"));
		URL url = null;
		try
		{
			url=new URL(urlAdress);
			URLConnection conn = url.openConnection();
			
			InputStreamReader sReader = new InputStreamReader (conn.getInputStream());
			BufferedReader bReader = new BufferedReader(sReader);
			String currentLine = bReader.readLine();
			while (currentLine!=null)
			{
				int index = currentLine.indexOf("<title>");
				if (index!=-1)
				{
					System.out.println (currentLine.substring(index+7, currentLine.indexOf("|")));
					break;
				}
				currentLine = bReader.readLine();
			}
		}catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
