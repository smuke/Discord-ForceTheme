![Discord screenshot](https://github.com/user-attachments/assets/63fc9980-8d70-4a05-8dd3-1b9fec358cd7)

# Discord-ForceTheme
Applies the midnight Discord theme and keeps it on restart!<br>
Currently works on Windows and macOS.

Note: You may need to run the program again after Discord updates.

## Disclaimer
This program adds a line to the index.js file in Discord modules.<br>
It can be dangerous to have any malicious code in this file.<br>
Use at your own risk. I am not responsible if anything happens to your Discord account.

## Usage
* Requires `Java` to be installed
* Go to [releases](https://github.com/smuke/Discord-ForceTheme/releases) and download the latest .jar
* Move the .jar file to the same drive as your Discord installation/data
* Navigate to the directory of the file in terminal and run `java -jar Discord-ForceTheme.jar`

## Other Themes
You can change the theme via the `ADD_CLASS_JS` constant.<br>
Default: `document.body.classList.add('theme-midnight');`

`theme-midnight` is the CSS class name<br>
Other theme available: `theme-darker`
