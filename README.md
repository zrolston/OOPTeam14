# OOPTeam14

<!--Dr. StrangeOOP or: How I stopped worrying and learned to love the objects. -->

An OO implementation of [Roads & Boats](https://github.com/zrolston/OOPTeam14/blob/mapEditor/demo/RB3Erules.pdf). 

### Compile and run the source code

```javascript
git clone -b master --single-branch git://github.com/zrolston/OOPTeam14/
cd OOPTeam14 && mv res/Images/ src
find ./src/* | grep .java > argfile
javac @argfile
java -cp src RunGame
```

![bride demo](https://github.com/zrolston/OOPTeam14/raw/mapEditor/demo/bridgeDemo.gif)

***

# Map editor
Allows users to create new maps, load and edit previously created maps, and export map files.


### Download and run a JAR file containing the packaged Java app
Click [here](https://raw.githubusercontent.com/zrolston/OOPTeam14/mapEditor/demo/MapEditor.jar) or use the UNIX/Linux command *wget* to download the JAR file:
 
```javascript
wget "https://raw.githubusercontent.com/zrolston/OOPTeam14/mapEditor/demo/MapEditor.jar" -O MapEditor.jar 
```
Run from the command line or double-click the executable JAR file:
```javascript
java -jar MapEditor.jar 
```

![map_editor demo](https://github.com/zrolston/OOPTeam14/raw/mapEditor/demo/mapDemo.gif)

