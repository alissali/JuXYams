#! /bin/sh
export JUXYAMSHOME=$HOME/Projects/JuXYams/java/classes
java -classpath $HOME/.jedit/jars/xalan.jar:/usr/share/java/xml-apis.jar:$HOME/.jedit/xerces.jar:$JUXYAMSHOME Yams.Yams $HOME/Projects/JuXYams/DescJeuYams.xml
