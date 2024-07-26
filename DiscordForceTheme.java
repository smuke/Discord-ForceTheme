import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Pattern;

public class DiscordForceTheme
{
    protected final static String ADD_CLASS_JS = "document.body.classList.add('theme-midnight');";
    // Fix broken style for member list
    protected final static String EXTRA_JS = "document.body.style.setProperty('--custom-channel-members-bg', 'var(--background-secondary)');";
    protected static String versionDirectoryRegex;
    protected static String dataDirectory;
    protected static File[] files;
    protected static String indexFilePath;

    public static void main(String[] args)
    {
        Path path = Paths.get(".");
        Path absolutePath = path.toAbsolutePath().normalize();
        String[] dirs = absolutePath.toString().split(Pattern.quote(File.separator));

        // Windows
        // C:\Users\name\AppData\Local\Discord\app-1.0.0\modules\discord_modules-1\discord_modules
        try
        {
            dataDirectory = Paths.get(dirs[0] + "\\" + dirs[1] + "\\" + dirs[2] + "\\AppData\\Local\\Discord").toString();
            files = Objects.requireNonNull(new File(dataDirectory).listFiles());
            versionDirectoryRegex = "app-\\d+\\.\\d+\\.\\d+";
            indexFilePath = "\\modules\\discord_modules-1\\discord_modules\\index.js";

            if (dataDirectory.isEmpty()) return;

            ForceThemeProcessor processor = new ForceThemeProcessor();
            processor.process();
        }
        catch (Exception exception)
        {
            System.out.println("Could not find the application directory for Windows: " + dataDirectory);
        }

        // Mac
        // /Users/name/Library/Application Support
        try
        {
            dataDirectory = Paths.get(dirs[0] + "/" + dirs[1] + "/" + dirs[2] + "/Library/Application Support/discord").toString();
            files = Objects.requireNonNull(new File(dataDirectory).listFiles());
            versionDirectoryRegex = "\\d+\\.\\d+\\.\\d+";
            indexFilePath = "/modules/discord_modules/index.js";

            ForceThemeProcessor processor = new ForceThemeProcessor();
            processor.process();
        }
        catch (Exception exception)
        {
            System.out.println("Could not find the application directory for Mac: " + dataDirectory);
        }
    }
}
