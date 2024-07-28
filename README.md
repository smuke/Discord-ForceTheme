![Discord screenshot](https://github.com/user-attachments/assets/63fc9980-8d70-4a05-8dd3-1b9fec358cd7)

# Discord-ForceTheme

Applies the midnight Discord theme and keeps it on restart!

Currently works on Windows and macOS.

**Note: You need to run the program again after Discord updates.**

> [!WARNING]
> This program adds a line to the index.js file in Discord modules.
> It can be dangerous to have any malicious code in this file.
> Use at your own risk. I am not responsible if anything happens to your Discord account.

## Installation

1. Requires `Java` to be installed
2. Go to [releases](https://github.com/smuke/Discord-ForceTheme/releases) and download the latest .jar
3. Make sure the .jar file is on the same drive as your Discord installation

### Run on Windows
- Right-click the directory containing the .jar file
- Select `Open in Terminal`
- Run `java -jar Discord-ForceTheme.jar`<br>

### Run on macOS
- Open the .jar file to run

## Other Themes

- You can change the theme via the `ADD_CLASS_JS` constant.
  - Default: `document.body.classList.add('theme-midnight');`
- `theme-midnight` is the CSS class name
- Other theme available: `theme-darker`
