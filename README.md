# OOPTeam14

***

# Map editor for [Roads & Boats](https://github.com/zrolston/OOPTeam14/blob/mapEditor/demo/RB3Erules.pdf)
Allows users to create new maps, load and edit previously created maps, and export map files.


## Download, compile and run the source code

```javascript
git clone https://github.com/zrolston/OOPTeam14 -b master --single-branch
cd OOPTeam14
mv res/Images/ src
(find ./src/* | grep .java > argfile) && javac @argfile
java -cp src Main
```

## Download a JAR file containing the packaged Java app
Click [here](https://raw.githubusercontent.com/zrolston/OOPTeam14/mapEditor/demo/MapEditor.jar) or use the UNIX/Linux command *wget* to download the JAR file:
 
```javascript
wget "https://raw.githubusercontent.com/zrolston/OOPTeam14/mapEditor/demo/MapEditor.jar" -O MapEditor.jar 
```
## Run the JAR file (JRE required)
Run from the command line or double-click the executable JAR file:
```javascript
java -jar MapEditor.jar 
```

![map demo](https://github.com/zrolston/OOPTeam14/raw/mapEditor/demo/mapDemo.gif)


***
