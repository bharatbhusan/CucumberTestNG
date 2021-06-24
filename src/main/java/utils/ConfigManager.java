package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigManager
{
	private static ConfigManager configManager;
	private static final Properties prop = new Properties();

	private ConfigManager()
	{
		BufferedReader reader;
		String path =".//config//config.properties";

		try
		{

			reader = new BufferedReader(new FileReader(path));
			prop.load(reader);
		}
		catch(Exception e)
		{
			throw new RuntimeException("Issue while loading or reading config.properties");
		}
	}

	public static ConfigManager getInstance()
	{
		if(configManager==null)
			synchronized (ConfigManager.class) {

				try
				{
					configManager = new ConfigManager();

				}
				catch(Exception e)
				{
					throw new RuntimeException("Issue while instatiating config Manager obj");
				}

			}
		return configManager;

	}

	public String getString(String key)
	{
		String value = prop.getProperty(key);
		if(!(value==null)) return value;
		throw new RuntimeException("Value is Null");
	}
}
