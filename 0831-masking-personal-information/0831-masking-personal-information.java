class Solution {
    public String maskEmail(String email) {
        email = email.toLowerCase();
        String[] parts = email.split("@");
        String name = parts[0];
        String domain = parts[1];
        String maskedName = name.charAt(0) + "*****" + name.charAt(name.length() - 1);
        
        return maskedName + "@" + domain;
    }
    public String maskPhone(String phone) {
        StringBuilder digits = new StringBuilder();
        for (char c : phone.toCharArray()) {
            if (Character.isDigit(c)) digits.append(c);
        }
        String last4 = digits.substring(digits.length() - 4);
        int countryCodeLength = digits.length() - 10;
        if (countryCodeLength == 0) return "***-***-" + last4;
        else if (countryCodeLength == 1) return "+*-***-***-" + last4;
        else if (countryCodeLength == 2) return "+**-***-***-" + last4;
        else return "+***-***-***-" + last4;
    }
    public String maskPII(String s) {
        if (s.contains("@")) return maskEmail(s);
        else return maskPhone(s);
    }
}