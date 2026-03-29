class Solution {
    final char delimiter = ';';
    final char escapeCharacter = '/';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        String regex = String.format("([%c%c\\\"])", escapeCharacter, delimiter);


        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            sb.append('\"');
            sb.append(
                str.replaceAll(regex, String.format("%c$1", escapeCharacter))
            );
            sb.append('\"');

            if (i < strs.size() - 1) {
                sb.append(delimiter);
            }
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        boolean escaped = false;
        List<String> res = new ArrayList<>();

        for (char c : str.toCharArray()) {
            if (escaped) {
                sb.append(c);
                escaped = false;
                continue;
            }

            if (c == escapeCharacter) {
                escaped = true;
                continue;
            }

            if (c == delimiter) {
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
                sb.delete(0, sb.length());
                continue;
            }

            sb.append(c);
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
        }

        return res;
    }
}
