package activities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;



public class Activity14 {

    public static void main(String[] args) {

        try {
          
            File sourceFile = new File("sample.txt");
            boolean fStatus = sourceFile.createNewFile();
            if (fStatus) {
				System.out.println("File created successfully!");
				FileUtils.writeStringToFile(sourceFile, "Some text in a file", Charset.defaultCharset());
			} else {
				System.out.println("File already exists at this path.");
			}
            String fileData = FileUtils.readFileToString(sourceFile, "UTF-8");
            System.out.println("Original File Content:");
            System.out.println(fileData);

          
            File destDir = new File("destDir");
            if (!destDir.exists()) {
                destDir.mkdir();
                System.out.println("Directory created: destDir");
            }

         
            FileUtils.copyFileToDirectory(sourceFile, destDir);
            System.out.println("File copied to destDir");

           
            File newFile = FileUtils.getFile(destDir, "sample.txt");

            String newFileData = FileUtils.readFileToString(newFile, "UTF-8");
            System.out.println("\nCopied File Content:");
            System.out.println(newFileData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

