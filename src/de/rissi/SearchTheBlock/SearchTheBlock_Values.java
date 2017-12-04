package de.rissi.SearchTheBlock;

import java.io.File;
import java.util.Random;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class SearchTheBlock_Values
{
	//Values

		// Messages
		public static String			ARENAALREDYEXIST		= "§3Arena already exist";
		public static String			ARENADOESENTEXIST		= "§3This Arena is not exist! Look at Upper/Lowercase";
		public static String			USECREATEARENACOMMAND	= "§3Use /createArena [Name]";
		public static String			USESETLOCCOMMAND		= "§3Use /setLoc [Arena] [pos1|pos2]";
		public static String			USESTARTCOMMAND			= "§3Use /start [Arena]";
		public static String			ARENACREATED			= "§3Arena was created";
		public static String			LOCATIONSET				= "§3Position set";
		public static String			GAMESTARTED				= "§3Spiel wurde gestartet";
	
		// File
		public static File				FILE					= new File("plugins/SearchTheBlock", "Arena.yml");
		public static FileConfiguration	CFG						= YamlConfiguration.loadConfiguration(FILE);
	
		// Random
		public static Random			RDM						= new Random();
		
	//Methods
		
		//File
		public static String loadFile() {
			try
			{
				CFG.load(FILE);
				return null;
			} catch (Exception e)
			{
				return e.getMessage();
			}
		}
		
		public static String saveFile() {
			try
			{
				CFG.save(FILE);
				return null;
			} catch (Exception e)
			{
				return e.getMessage();
			}
		}
	
}
