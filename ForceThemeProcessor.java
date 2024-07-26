import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ForceThemeProcessor extends DiscordForceTheme
{
    private final Pattern pattern;

    public ForceThemeProcessor()
    {
        pattern = Pattern.compile(versionDirectoryRegex);
    }

    public void process()
    {
        for (File file : files)
        {
            String fileName = file.getName();
            if (!pattern.matcher(fileName).matches()) continue;

            File indexFile = new File(dataDirectory + "/" + fileName + indexFilePath);

            System.out.println("Found file " + indexFile);

            try
            {
                Scanner scan = new Scanner(indexFile);
                scan.nextLine();

                if (scan.hasNextLine() && !scan.nextLine().isEmpty())
                {
                    System.out.println("The index.js file has already been modified!");
                    return;
                }

                System.out.println("Writing...");

                FileOutputStream outputStream = new FileOutputStream(indexFile, true);
                PrintWriter outFile = new PrintWriter(outputStream);

                outFile.write("\n" + ADD_CLASS_JS + "\n" + EXTRA_JS);

                System.out.println("Successfully added the theme code to " + indexFile);

                outFile.close();
            }
            catch (FileNotFoundException exception)
            {
                System.out.println("An error occurred! File was not found.");
            }
        }
    }
}
