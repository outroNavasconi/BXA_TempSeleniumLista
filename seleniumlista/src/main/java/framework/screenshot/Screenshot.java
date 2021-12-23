package framework.screenshot;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import framework.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {	
	private String fileMask;
	private String folderMask;
	
	public Screenshot() {		
		this.fileMask = "%s.jpg";
		String sep = File.separator;
		this.folderMask = String.format("target%sevidences%s%s%s", sep, sep, "%s", sep);
	}
	
	public void takeScreenshot(String folder, String fileName) throws IOException {
		File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		this.createFolder(String.format(this.folderMask, folder));
		String pathFile = String.format(this.folderMask, folder) + String.format(this.fileMask, fileName);
		Files.copy(file, new File(pathFile));		
	}	
	
	private void createFolder(String path) {
		File folder = new File(path);
		if (!folder.exists())
			folder.mkdirs();
	}
}
