package lightstorm.polarin.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;
import java.util.Random;

public class StringWords {
	static String fs = FileSystems.getDefault().getSeparator();
	static Properties prop;	
	 public static final String testdatapath=fs+"src"+fs+"main"+fs+"resources"+fs+"TestData"+fs+"testData.properties";
	 public static String getRandomWord(String[] words) {
		
	        Random random = new Random();
	        int index = random.nextInt(words.length);
	        return words[index];
	    }
	 
	 public static String enterThePortName() {
         prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	            String[] words = prop.getProperty("Port").split(",");
	            // Replace "your.property.key" with the actual key in your property file
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;	  
	 }
	 
	 public static String enterVirtualConnectionName() {
		 prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	            String[] words = prop.getProperty("VirtualConnection").split(",");
	            // Replace "your.property.key" with the actual key in your property file
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;	  
		 
	 }
	 public static String enterVirtualRouterName() {
		 prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "your.property.key" with the actual key in your property file
	            String[] words = prop.getProperty("VirtualRouter").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();
	           
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;
	 }
	
	public static String usernames() {
		prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "your.property.key" with the actual key in your property file
	            String[] words = prop.getProperty("VirtualRouter").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	
	public static String enterBillingProfile() {
		prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "your.property.key" with the actual key in your property file
	            String[] words = prop.getProperty("ExistingBillingprofile").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;		
	    }
	public static String enterTheActivePortLocation() {
		prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "your.property.key" with the actual key in your property file
	            String[] words = prop.getProperty("ActivePortLocation").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;
	}
	public static String enterTheActiveVirtualRouter() {
		prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "key" with the actual key in your property file
	            String[] words = prop.getProperty("CreatedVirtualRouter").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;	
	}
	
	public static String enterTheCreatedPortfromList() {
		prop = new Properties();
		 try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+testdatapath)) {
	            prop.load(fis);
	         // Replace "key" with the actual key in your property file
	            String[] words = prop.getProperty("CreatedPortList").split(",");
	           String randomWord = getRandomWord(words);
	           System.out.println("Randomly selected word: " + randomWord);     
	           return randomWord.trim();  
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;	
	}
	
}
