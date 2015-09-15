java -jar "%~dp0antlr-3.4-complete.jar" .\src\thelang\TheLang.g
:: javac -sourcepath .\src -cp .\*.jar .\src\thelang\Main.java -d bin
:: java -cp .\antlr-3.5-complete.jar;.\bin thelang.Main %1