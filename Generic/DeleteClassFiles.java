package Generic;
import java.io.File;

/**
 * This utility class can be used to delete 
 * folders recursively in java
 * @author pankaj
 */
public class DeleteClassFiles {

    public static void main(String[] args) {
        String folder = "./";
        //delete folder recursively
        recursiveDelete(new File(folder));
        System.out.println("Removed all class files");
    }
    
    public static void recursiveDelete(File file) {
        //to end the recursive loop
        if (!file.exists())
            return;
        
        //if directory, go inside and call recursively
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                //call recursively
                recursiveDelete(f);
            }
        }
        //call delete to delete files and empty directory
        if(file.getName().toString().matches(".*\\.class")) {
        file.delete();
        System.out.println("deleted: "+ file.getName().toString());
        }

    }
}