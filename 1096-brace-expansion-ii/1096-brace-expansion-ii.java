class Solution {
    private String expr;
    private int pos;

    public List<String> braceExpansionII(String expression) {
        this.expr = expression;
        this.pos = 0;
        Set<String> result = parseExpression();
        return new ArrayList<>(result);
    }

    private Set<String> parseExpression() {
        Set<String> result = new TreeSet<>();
        result.addAll(parseConcatenation());

        while (pos < expr.length() && expr.charAt(pos) == ',') {
            pos++; 
            result.addAll(parseConcatenation());
        }
        return result;
    }

    private Set<String> parseConcatenation() {
        Set<String> current = parseFactor();

        while (pos < expr.length()) {
            char c = expr.charAt(pos);
            if (c == ',' || c == '}') break;
            Set<String> next = parseFactor();
            current = crossProduct(current, next);
        }
        return current;
    }

    private Set<String> parseFactor() {
        char c = expr.charAt(pos);

        if (c == '{') {
            pos++; 
            Set<String> inner = parseExpression();
            pos++; 
            return inner;
        }
        pos++;
        Set<String> single = new TreeSet<>();
        single.add(String.valueOf(c));
        return single;
    }

    private Set<String> crossProduct(Set<String> a, Set<String> b) {
        Set<String> result = new TreeSet<>();
        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }
        return result;
    }
}