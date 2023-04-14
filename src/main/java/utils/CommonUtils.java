package utils;

public class CommonUtils {

	
	
	public static String getUniqueEmail() {

		String text = getRandomString(8);
		String email = "kk" + text.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
		System.out.println(email);
		return email;
	}

	public static String getUniquePassword() {
		String password = getRandomString1(8);
		System.out.println(password);
		return password;
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String chars = "abcdefghijklmnopqrstuvwxyz123456789";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * chars.length());
			sb.append(chars.charAt(index));
		}
		String email = sb.toString();
		return email;

	}

	public static String getRandomString1(int length) {
		StringBuilder sb = new StringBuilder();
		String chars = "123456789";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * chars.length());
			sb.append(chars.charAt(index));
		}
		String password = sb.toString();
		return password;

	}
}
