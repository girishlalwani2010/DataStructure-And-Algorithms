package string;

public class ValidateIPAddress {
	private boolean isValidHexa(char a) {
		return (a >= 'a' && a <= 'f') || (a >= 'A' && a <= 'F') || (a >= '0' && a <= '9');
	}

	private boolean isValidIPV4(String IP) {
		if (IP.charAt(IP.length() - 1) == '.') {
			return false;
		}
		String[] a = IP.split("\\.");
		if (a.length != 4)
			return false;
		for (String p : a) {
			if (p.isEmpty() || p.length() > 1 && p.charAt(0) == '0' || p.length() > 3)
				return false;
			int value;
			try {
				value = Integer.parseInt(p);
			} catch (NumberFormatException nfe) {
				return false;
			}

			if (!String.valueOf(value).equals(p) || value < 0 || value > 255)
				return false;
		}
		return true;
	}

	private boolean isValidIPV6(String IP) {
		if (IP.charAt(IP.length() - 1) == ':') {
			return false;
		}
		String[] a = IP.split(":");
		if (a.length != 8)
			return false;
		for (String p : a) {
			if (p.length() > 4 || p.isEmpty())
				return false;
			for (char c : p.toCharArray())
				if (!isValidHexa(c))
					return false;
		}
		return true;
	}

	public String validIPAddress(String IP) {
		if (IP.contains(".")) {
			if (isValidIPV4(IP))
				return "IPv4";
			else
				return "Neither";
		} else if (IP.contains(":")) {
			if (isValidIPV6(IP))
				return "IPv6";
			else
				return "Neither";
		} else {
			return "Neither";
		}
	}
}
