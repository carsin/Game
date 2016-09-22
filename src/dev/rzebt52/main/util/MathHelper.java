package dev.rzebt52.main.util;

public class MathHelper {

	public static float lerp(float a, float b, float amount) {
		if (Math.abs(b - a) >= 0.0005f)
			return a + amount * (b - a);
		return b;
	}

	public static float clamp(float a, float max, float min) {
		return Math.min(max, Math.max(min, a));
	}

	public static float clamp(float a, float b, float max, float min) {
		if (a >= min) {
			if (b <= max) {
				return a;
			} else {
				return max - (b - a);
			}
		} else {
			return min;
		}

	}

	public static int safeDivide(int a, int b) {
		try {
			return a / b;
		} catch (ArithmeticException e) {
			return 0;
		}
	}

	public static int safeRemainder(int a, int b) {
		try {
			return a % b;
		} catch (ArithmeticException e) {
			return 0;
		}
	}

}
