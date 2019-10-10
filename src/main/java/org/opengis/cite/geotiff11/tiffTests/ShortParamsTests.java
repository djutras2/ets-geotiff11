package org.opengis.cite.geotiff11.tiffTests;

import java.util.Arrays;
import java.util.List;

import org.opengis.cite.geotiff11.util.TiffDump;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// https://github.com/opengeospatial/geotiff/blob/5d6ab0ba54f1ed0174901dd84240817dc9dbe011/GeoTIFF_Standard/standard/abstract_tests/TIFF_Tests/TEST_Short_Param.adoc

public class ShortParamsTests extends CommonTiffMeta {
	
	/*
	 * GeoKey Directory Test Test
	 * id: http://www.opengis.net/spec/GeoTIFF/1.1/conf/ShortParameters
	 * Requirements:
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoKeyDirectoryTag.KeyEntry.ID
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoKeyDirectoryTag.keyEntryTIFFTagLocation
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoKeyDirectoryTag.keyEntryKeyCount
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoKeyDirectoryTag.keyEntryValueOffset
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoShortParams.Criteria
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeoShortParams.Location
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GTModelTypeGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GTRasterTypeGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeodeticCRSGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/GeodeticDatumGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/PrimeMeridianGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/UnitsGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/EllipsoidGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/ProjectedCRSGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/ProjectionGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/ProjMethodGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/VerticalGeoKey
	 *  http://www.opengis.net/spec/GeoTIFF/1.1/req/VerticalDatumGeoKey
	 * Purpose: Verify a Short parameter
	 * Pre-conditions: The GeoKeyDirectory and GeoKeyOffset values have been set Test Variables:
	 * Test Variables: ...
	 */

	private TiffDump.Directory directory;
	private List<Object> keyEntrySet;
	
	@BeforeClass
	public void setUpGeoKeyDirectory() {
		directory = tiffDump.getGeoKeyDirectory();
		Assert.assertTrue(directory != null);
		keyEntrySet = directory.getTag(34735).getValues();	
		Assert.assertTrue(keyEntrySet != null);
	}
	
/*	@Test(description = "GeoKey Directory Test	")
	public void verifyGeoKeyDirectoryTests() throws Exception {

		TiffDump.Directory directory = tiffDump.getGeoKeyDirectory();

		List<Object> keyEntrySet = directory.getTag(34735).getValues();
		if (keyEntrySet != null) {
			for(int i = 4; i < keyEntrySet.size(); i += 4) {							
				// process the second Short integer in the Key Entry Set
				int type = (int) keyEntrySet.get(i+1);
				
				// get the Short Params
				if(type == 0 || type == 34735) {
					// process the first Short integer in the Key Entry Set
					int geoKey = (int) keyEntrySet.get(i);
					// process the third Short integer in the Key Entry Set
					int keyLength = (int) keyEntrySet.get(i+2);
					
					int value;
					
					if(keyLength == 1) {
						// SET KeyValueOffset = GeoKeyDirectory + GeoKeyOffset + 6
						value = (int) keyEntrySet.get(i+3);
					} else {
						// SET KeyValueOffset = GeoKeyDirectory + (KeyValueOffset * 2)
						value = (int) keyEntrySet.get(keyLength); // TODO: verify this is a correct interpretation of the ats...
					}
					
					// validate
					if(geoKey == 0) {
						continue;
					}
					if(geoKey == 1024) {
						continue;
					}
				}	
			}
		}
	}*/
	
	//  https://github.com/opengeospatial/geotiff/blob/68d8f902293ad64526889daa055892ea30f9e9ea/GeoTIFF_Standard/Detailed%20Test%20Suite/abstract_tests/Requirements_Trace_Matrix.adoc
	//	GeoKey	Requirements Class
	//	0		ignore
	//	1024	GTModelTypeGeoKey
	
	int processFourthShort(int index, int keyLength) {
		// process the fourth Short integer in the Key Entry Set
		if(keyLength == 1) {
			// SET KeyValueOffset = GeoKeyDirectory + GeoKeyOffset + 6
			return (int) keyEntrySet.get(index+3);
		} else {
			// SET KeyValueOffset = GeoKeyDirectory + (KeyValueOffset * 2)
			return (int) keyEntrySet.get(keyLength); // TODO: verify this is a correct interpretation of the ats...
		}
	}
	
	int processThirdShort(int index) {
		// process the third Short integer in the Key Entry Set
		return (int) keyEntrySet.get(index + 2);
	}
	
	int processSecondShort(int index) {
		// process the second Short integer in the Key Entry Set
		return (int) keyEntrySet.get(index + 1);
	}
	
	int processFirstShort(int index) {
		// process the first Short integer in the Key Entry Set
		return (int) keyEntrySet.get(index);
	}
	
	@Test(description = "Short Params GTModelTypeGeoKey (1024) Test", dependsOnGroups ={"verifyGeoKeyDirectory"})
	public void verifyGTModelTypeGeoKey() throws Exception {
		// the GTModelTypeGeoKey SHALL have ID = 1024
		int index = keyEntrySet.indexOf(1024);
		// a GeoTIFF file SHALL include a GTModelTypeGeoKey
		Assert.assertTrue(index != -1);
		
		// process the second Short integer in the Key Entry Set
		int type = processSecondShort(index);
		int geoKey = processFirstShort(index);
		int keyLength = processThirdShort(index);
		int value = processFourthShort(index, keyLength);
		
		// the GTModelTypeGeoKey SHALL have type = SHORT		
		Assert.assertTrue(type == 0 || type == 34735);
		// or
		if(!(type == 0 || type == 34735)) {
			throw new Exception("GTModelTypeGeoKey should be of type SHORT.");
		}
		
		// the GTModelTypeGeoKey value SHALL be: ...
		Assert.assertTrue(Arrays.asList(0, 1, 2, 3, 32767).contains(value));

		// GTModelTypeGeoKey values in the range 4-32766 SHALL be reserved
		// TODO
		
		// GTModelTypeGeoKey values in the range 32768-65535 SHALL be private
		// TODO
		
		// if the GTModelTypeGeoKey value is 1 (Model CRS is a projected 2D CRS) then the GeoTIFF file SHALL include a ProjectedCRSGeoKey
		// if the GTModelTypeGeoKey value is 2 (Model CRS is a geographic 2D CRS) then the GeoTIFF file SHALL include a GeodeticCRSGeoKey
		// if the GTModelTypeGeoKey value is 3 (Model CRS is a geocentric CRS) then the GeoTIFF file SHALL include a GeodeticCRSGeoKey
		// if the GTModelTypeGeoKey value is 32767 (user-defined) then the GTCitationGeoKey SHALL be populated
		switch(value) {		
			case 1:
				Assert.assertTrue(keyEntrySet.indexOf(3072) != -1);
				break;
			case 2:
			case 3:
				Assert.assertTrue(keyEntrySet.indexOf(3072) != -1);
				break;
			case 32767:
				int gTCitationGeoKeyIndex = keyEntrySet.indexOf(1026);
				Assert.assertTrue(gTCitationGeoKeyIndex != -1);
				String gTCitationGeoKey = ((String) directory.getTag(34737).getValues().get(0)).substring(
						keyEntrySet.indexOf(gTCitationGeoKeyIndex + 3), 
						keyEntrySet.indexOf(gTCitationGeoKeyIndex + 3) + keyEntrySet.indexOf(gTCitationGeoKeyIndex + 2));
				System.out.println("shortparams:" + gTCitationGeoKey);
				Assert.assertFalse(gTCitationGeoKey.isEmpty()); // TODO: this is pretty rough...
				break;
		}
	}

	//	1025	GTRasterTypeGeoKey
	
	@Test(description = "Short Params GTRasterTypeGeoKey (1025) Test", dependsOnGroups ={"verifyGeoKeyDirectory"})
	public void verifyGTRasterTypeGeoKey() throws Exception {
		// the GTModelTypeGeoKey SHALL have ID = 1025
		int index = keyEntrySet.indexOf(1025);

		// not required
		if(index == -1) {
			return;
		}
		
		// process the second Short integer in the Key Entry Set
		int type = processSecondShort(index);
		int geoKey = processFirstShort(index);
		int keyLength = processThirdShort(index);
		int value = processFourthShort(index, keyLength);
		
		// the GTRasterTypeGeoKey SHALL have type = SHORT		
		Assert.assertTrue(type == 0 || type == 34735);
		// or
		if(!(type == 0 || type == 34735)) {
			throw new Exception("GTRasterTypeGeoKey should be of type SHORT.");
		}
		
		// the GTRasterTypeGeoKey value SHALL be: ...
		Assert.assertTrue(Arrays.asList(0, 1, 2, 32767).contains(value));
		
		// GTRasterTypeGeoKey values in the range 3-32766 SHALL be reserved
		Assert.assertFalse(value >= 3 && value <= 32766);
		
		// GTRasterTypeGeoKey values in the range 32768-65535 SHALL be private
		// value out of bounds
		Assert.assertFalse(value > 65535 || value < 0);
	}
	
	//	2048	GeodeticCRSGeoKey
	
	@Test(description = "Short Params GeodeticCRSGeoKey (2048) Test", dependsOnGroups ={"verifyGeoKeyDirectory"})
	public void verifyGeodeticCRSGeoKey() throws Exception {
		// the GeodeticCRSGeoKey SHALL have ID = 2048
		int index = keyEntrySet.indexOf(2048);

		// not required
		if(index == -1) {
			return;
		}
		
		// process the second Short integer in the Key Entry Set
		int type = processSecondShort(index);
		int geoKey = processFirstShort(index);
		int keyLength = processThirdShort(index);
		int value = processFourthShort(index, keyLength);
		
		// the GeodeticCRSGeoKey SHALL have type = SHORT		
		Assert.assertTrue(type == 0 || type == 34735);
		// or
		if(!(type == 0 || type == 34735)) {
			throw new Exception("GeodeticCRSGeoKey should be of type SHORT.");
		}
	
		
		// if the GeodeticCRSGeoKey value is 32767 (User-Defined) then the GeodeticCitationGeoKey 2049, GeodeticDatumGeoKey 2050 and at least one of GeogAngularUnitsGeoKey 2054 or GeogLinearUnitsGeoKey 2052 SHALL be populated
		if(value == 32767) {
			Assert.assertTrue(keyEntrySet.indexOf(2049) != -1 && keyEntrySet.indexOf(2050) != -1 && (keyEntrySet.indexOf(2054) != -1 || keyEntrySet.indexOf(2052) != -1));
		} else {
			// GeodeticCRSGeoKey values in the range 1001-1023 SHALL be reserved
			Assert.assertFalse(value >= 1001 && value <= 1023);
			
			// GeodeticCRSGeoKey values in the range 1024-32766 SHALL be EPSG geodetic CRS codes (geographic 2D CRS, geographic 3D CRS, and geocentric CRS)
			Assert.assertFalse(!keyEntrySet.get(2).equals(1) && value >= 1024 && value <= 32766);
			
			// GeodeticCRSGeoKey values in the range 1-1000 SHALL be obsolete EPSG/POC Geographic Codes
			Assert.assertFalse(!keyEntrySet.get(2).equals(0) && value >= 1 && value <= 1000);
					
			// GeodeticCRSGeoKeyvalues in the range 32768-65535 SHALL be private
			// value out of bounds
			Assert.assertFalse(value > 65535 || value < 0);
		}
	}
	
	//	2050	GeodeticDatumGeoKey
	//	2051	PrimeMeridianGeoKey
	//	2052	UnitsGeoKey (Linear Units)
	//	2054	UnitsGeoKey (Angular Units)
	//	2056	EllipsoidGeoKey
	//	2060	UnitsGeoKey (Azimuth Units)
	//	3072	ProjectedCRSGeoKey
	//	3074	ProjectionGeoKey
	//	3075	ProjMethodGeoKey
	//	3076	UnitsGeoKey (Linear Units)
	//	4096	VerticalGeoKey
	//	4098	VerticalDatumGeoKey
	//	4099	UnitsGeoKey (Vertical Units)

}