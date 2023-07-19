
package lightstorm.polarin.utility;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtil {

	private static ThreadLocal<SoftAssert> softAssertThreadLocal = new ThreadLocal<>();

	public static void initializeSoftAssert() {
		SoftAssert softAssert = new SoftAssert();
		softAssertThreadLocal.set(softAssert);
	}

	public static SoftAssert getSoftAssert() {

		return softAssertThreadLocal.get();

	}

	public static void assertAll() {
		SoftAssert softAssert = getSoftAssert();
		if (softAssert != null) {
			softAssert.assertAll();
			softAssertThreadLocal.remove();
		}
	}
}
