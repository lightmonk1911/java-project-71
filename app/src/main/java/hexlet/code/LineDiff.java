package hexlet.code;

public final class LineDiff {
    LineDiff(Object wasValue, Object nowValue, LineDiffState stateValue) {
        this.was = wasValue;
        this.now = nowValue;
        this.state = stateValue;
    }

    private Object was;
    private Object now;
    private LineDiffState state;

    public Object getWas() {
        return was;
    }

    public Object getNow() {
        return now;
    }

    public LineDiffState getState() {
        return state;
    }
}
