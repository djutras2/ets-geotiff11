cd c:\Users\RDAGCDLJ\Documents\FY20\GeoTIFF\example_tiffs\COG_DEF_OR

setlocal enabledelayedexpansion
for %%f in (*.tif) do (
    set TEMP=%%~nf
    call "C:\Users\RDAGCDLJ\Documents\FY20\GeoTIFF\ets-geotiff11\src\site\useful batches\JREPL.bat" "file:///(.*?)</entry" "file:///c:/Users/RDAGCDLJ/Documents/FY20/GeoTIFF/example_tiffs/COG_DEF_OR/!TEMP!.tif</entry" /m /f "C:\Users\RDAGCDLJ\Documents\FY20\GeoTIFF\ets-geotiff11\src\main\resources\test-run-props.xml" /O -
    echo !TEMP!
    "C:\Program Files\Java\jre1.8.0_241\bin\javaw.exe" -Dfile.encoding=UTF-8 -classpath "C:\Users\RDAGCDLJ\Documents\FY20\GeoTIFF\ets-geotiff11\target\classes;C:\Users\RDAGCDLJ\.m2\repository\org\opengis\cite\teamengine\teamengine-spi\4.9\teamengine-spi-4.9.jar;C:\Users\RDAGCDLJ\.m2\repository\org\testng\testng\6.9.10\testng-6.9.10.jar;C:\Users\RDAGCDLJ\.m2\repository\com\beust\jcommander\1.48\jcommander-1.48.jar;C:\Users\RDAGCDLJ\.m2\repository\com\sun\jersey\jersey-server\1.19\jersey-server-1.19.jar;C:\Users\RDAGCDLJ\.m2\repository\com\sun\jersey\contribs\jersey-multipart\1.19\jersey-multipart-1.19.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jvnet\mimepull\mimepull\1.9.3\mimepull-1.9.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\jena\jena-core\3.1.0\jena-core-3.1.0.jar;C:\Users\RDAGCDLJ\.m2\repository\org\slf4j\slf4j-api\1.7.20\slf4j-api-1.7.20.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\jena\jena-iri\3.1.0\jena-iri-3.1.0.jar;C:\Users\RDAGCDLJ\.m2\repository\commons-cli\commons-cli\1.3\commons-cli-1.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\jena\jena-base\3.1.0\jena-base-3.1.0.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\jena\jena-shaded-guava\3.1.0\jena-shaded-guava-3.1.0.jar;C:\Users\RDAGCDLJ\.m2\repository\com\github\andrewoma\dexx\collection\0.6\collection-0.6.jar;C:\Users\RDAGCDLJ\.m2\repository\org\slf4j\slf4j-jdk14\1.7.21\slf4j-jdk14-1.7.21.jar;C:\Users\RDAGCDLJ\.m2\repository\org\opengis\cite\schema-utils\1.8\schema-utils-1.8.jar;C:\Users\RDAGCDLJ\.m2\repository\org\opengis\cite\saxon\saxon9\9.0.0.8\saxon9-9.0.0.8.jar;C:\Users\RDAGCDLJ\.m2\repository\xerces\xercesImpl\2.11.0\xercesImpl-2.11.0.jar;C:\Users\RDAGCDLJ\.m2\repository\xml-apis\xml-apis\1.4.01\xml-apis-1.4.01.jar;C:\Users\RDAGCDLJ\.m2\repository\xml-resolver\xml-resolver\1.2\xml-resolver-1.2.jar;C:\Users\RDAGCDLJ\.m2\repository\com\thaiopensource\jing\20091111\jing-20091111.jar;C:\Users\RDAGCDLJ\.m2\repository\isorelax\isorelax\20030108\isorelax-20030108.jar;C:\Users\RDAGCDLJ\.m2\repository\com\sun\jersey\jersey-client\1.19\jersey-client-1.19.jar;C:\Users\RDAGCDLJ\.m2\repository\com\sun\jersey\jersey-core\1.19\jersey-core-1.19.jar;C:\Users\RDAGCDLJ\.m2\repository\javax\ws\rs\jsr311-api\1.1.1\jsr311-api-1.1.1.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\commons\commons-lang3\3.9\commons-lang3-3.9.jar;C:\Users\RDAGCDLJ\.m2\repository\commons-io\commons-io\2.4\commons-io-2.4.jar;C:\Users\RDAGCDLJ\.m2\repository\org\apache\commons\commons-csv\1.5\commons-csv-1.5.jar;C:\Users\RDAGCDLJ\.m2\repository\org\openpreservation\jhove\jhove-modules\1.16.6\jhove-modules-1.16.6.jar;C:\Users\RDAGCDLJ\.m2\repository\org\openpreservation\jhove\jhove-core\1.16.6\jhove-core-1.16.6.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jwat\jwat-common\1.0.3\jwat-common-1.0.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jwat\jwat-gzip\1.0.3\jwat-gzip-1.0.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jwat\jwat-arc\1.0.3\jwat-arc-1.0.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jwat\jwat-archive-common\1.0.3\jwat-archive-common-1.0.3.jar;C:\Users\RDAGCDLJ\.m2\repository\org\jwat\jwat-warc\1.0.3\jwat-warc-1.0.3.jar" org.opengis.cite.geotiff11.TestNGController c:\Users\RDAGCDLJ\Documents\FY20\GeoTIFF\ets-geotiff11\src\main\resources\test-run-props.xml
)

PAUSE

