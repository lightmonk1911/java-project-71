package hexlet.code;

public final class LineDiff {

    public Object getWas() {
        return was;
    }

    public Object getNow() {
        return now;
    }

    public LineDiffState getState() {
        return state;
    }

    private Object was;
    private Object now;
    private LineDiffState state;

    LineDiff(Object wasValue, Object nowValue, LineDiffState stateValue) {
        this.was = wasValue;
        this.now = nowValue;
        this.state = stateValue;
    }
}
