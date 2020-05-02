package idwall.desafio.string;

public class IdwallFormatter extends StringFormatter {
    private String formattedString = "";

    /**
     * Should format as described in the challenge
     *
     * @param text to be formatted
     * @param limit character limit
     * @return string for console printing
     */
    @Override
    public String format(int limit, String text) throws UnsupportedOperationException {
        StringBuilder builder = new StringBuilder(text);
        int position;

        if (text.length() < limit) {
            formattedString = formattedString.concat(text);
            return formattedString;
        }

        char testing = builder.charAt(limit);
        if (testing == ' ') {
            position = limit;
            if (builder.substring(0, limit).contains("\n")) {
                position = builder.substring(0, limit).lastIndexOf("\n");
            }
            formattedString = formattedString.concat(builder.substring(0, position) + "\n");
            builder = new StringBuilder(builder.substring(position + 1, builder.length()));
            text = builder.toString();
            format(limit, text);
        } else {
            position = builder.substring(0, limit).lastIndexOf(' ');
            char spaceTest = builder.charAt(limit - 1);
            if (spaceTest == ' ') {
                position = limit - 1;
            }
            if (builder.substring(0, limit).contentEquals("\n")) {
                position = builder.substring(0, limit).lastIndexOf("\n");
            }
            formattedString = formattedString.concat(builder.substring(0, position) + "\n");
            builder = new StringBuilder(builder.substring(position + 1, builder.length()));
            text = builder.toString();
            format(limit, text);
        }
        return formattedString;
    }
}
