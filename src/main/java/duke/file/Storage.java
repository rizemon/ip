package duke.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Storage class deals with file-related operations.
 */
public class Storage {

    /* Name of directory where files are saved to */
    private String dataDirPath;

    /**
     * Instantiates a new file storage handler.
     */
    public Storage(String dataDir) {
        this.dataDirPath = dataDir;
        initDataDir();
    }

    /**
     * Create a directory on the file system, even if it already exists.
     */
    private void initDataDir() {
        File dataDir = new File(dataDirPath);
        dataDir.mkdir();
    }

    /**
     * Overwrites the file at the given file path with the given contents.
     *
     * @param content  Data to write to the file.
     * @param filePath Path of the file to write to.
     */
    public void writeToFile(String content, String filePath) throws IOException {
        FileWriter fw = new FileWriter(new File(dataDirPath, filePath));
        fw.write(content);
        fw.close();
    }
}
