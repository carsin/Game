package dev.rzebt52.main.util;

public class LocalMath {

	public static float lerp(float num1, float num2, float amount) {
		if (Math.abs(num2 - num1) >= 0.0005f)
			return num1 + amount * (num2 - num1);
		return num2;
	}

	public static float clamp(float value, float max, float min) {
		return Math.min(max, Math.max(min, value));
	}

	public static float clamp(float value1, float value2, float max, float min) {
		if (value1 >= min) {
			if (value2 <= max) {
				return value1;
			} else {
				return max - (value2 - value1);
			}
		} else {
			return min;
		}

	}

}
