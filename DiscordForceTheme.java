import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DiscordForceTheme
{
    final static String ADD_CLASS_JS = "document.body.classList.add(\"theme-midnight\");";
    final static String VERSION_DIRECTORY_REGEX = "\\d+\\.\\d+\\.\\d+";

    public static void main(String[] args)
    {
        Path path = Paths.get(".");
        Path absolutePath = path.toAbsolutePath().normalize();
        String[] dirs = absolutePath.toString().split("/");

        // /Users/name/Library/Application Support
        try
        {
            String finalDir = Paths.get(dirs[0] + "/" + dirs[1] + "/" + dirs[2] + "/Library/Application Support/discord").toString();
            File[] files = Objects.requireNonNull(new File(finalDir).listFiles());

            Pattern pattern = Pattern.compile(VERSION_DIRECTORY_REGEX);

            for (File file : files)
            {
                String fileName = file.getName();
                if (!pattern.matcher(fileName).matches()) continue;

                File indexFile = new File(finalDir + "/" + fileName + "/modules/discord_modules/index.js");

                System.out.println("Found file " + indexFile);

                try
                {
                    Scanner scan = new Scanner(indexFile);
                    scan.nextLine();

                    if (scan.hasNextLine() && scan.nextLine().length() > 0)
                    {
                        System.out.println("The index.js file has already been modified!");
                        return;
                    }

                    System.out.println("Writing...");

                    FileOutputStream outputStream = new FileOutputStream(indexFile, true);
                    PrintWriter outFile = new PrintWriter(outputStream);

                    outFile.write("\n" + ADD_CLASS_JS);

                    System.out.println("Successfully added the theme code to " + indexFile);

                    outFile.close();
                }
                catch (FileNotFoundException exception)
                {
                    System.out.println("An error occurred! File was not found.");
                }
            }
        }
        catch (Exception exception)
        {
            System.out.println("An error occurred! Could not find the application directory.");
        }
    }
}
