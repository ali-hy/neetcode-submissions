class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
                sb.append(c);
        }

        String filteredStr = sb.toString();

        for ( int i = 0; i < filteredStr.length(); i++ ) {
            if (filteredStr.charAt(i) != filteredStr.charAt(filteredStr.length() - 1 - i))
                return false;
        }
        return true;
    }
}
